package org.fasttrackit.youtubevideoplayer;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.fasttrackit.youtubevideoplayer.exception.ResourceNotFoundException;
import org.fasttrackit.youtubevideoplayer.service.LinkService;
import org.fasttrackit.youtubevideoplayer.transfer.SaveLinkRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest
class LinkServiceIntegrationTests {

    //field injection
    @Autowired
    private LinkService linkService;

    @Test
    void createLink_whenValidRequest_thenReturnCreatedLink() {
        createLink();
    }


    @Test
    void createLink_whenMissingMandatoryProperties_thenThrowException(){
        SaveLinkRequest request = new SaveLinkRequest();

        try {
            linkService.createLink(request);
        } catch (Exception e) {
            assertThat("Unexpected exception thrown", e instanceof ConstraintViolationException);
        }
    }

    @Test
    void getLink_whenExistingLink_thenReturnLink(){
        Link link = createLink();

        Link response = linkService.getLink(link.getId());

        assertThat(response, notNullValue());
        assertThat(response.getId(), greaterThan(0L));
        assertThat(response.getLink(), is(link.getLink()));
        assertThat(response.getTitle(), is(link.getTitle()));
        assertThat(response.getTime(), is(link.getTime()));

    }

    @Test
    void getLink_whenNonExistingLink_thenThrowResourceNotFoundException(){
        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> linkService.getLink(0));

    }

    private Link createLink() {
        SaveLinkRequest request = new SaveLinkRequest();
        request.setLink("https://www.youtube.com/watch?v=L_jWHffIx5E");
        request.setTitle("Smash Mouth - All Star");
        request.setTime("&t=20");

        Link link = linkService.createLink(request);

        //assertions
        assertThat(link, notNullValue());
        assertThat(link.getId(), greaterThan(0L));
        assertThat(link.getLink(), is(request.getLink()));
        assertThat(link.getTitle(), is(request.getTitle()));
        assertThat(link.getTime(), is(request.getTime()));

        return link;
    }


}




