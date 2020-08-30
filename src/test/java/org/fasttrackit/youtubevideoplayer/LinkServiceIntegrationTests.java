package org.fasttrackit.youtubevideoplayer;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.fasttrackit.youtubevideoplayer.service.LinkService;
import org.fasttrackit.youtubevideoplayer.transfer.SaveLinkRequest;
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
    }

    @Test
    void createProduct_whenMissingMandatoryProperties_thenThrowException(){
        SaveLinkRequest request = new SaveLinkRequest();

        try {
            linkService.createLink(request);
        } catch (Exception e) {
            assertThat("Unexpected exception thrown", e instanceof ConstraintViolationException);
        }
    }

}




