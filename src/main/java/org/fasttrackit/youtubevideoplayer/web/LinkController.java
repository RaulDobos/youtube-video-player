package org.fasttrackit.youtubevideoplayer.web;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.fasttrackit.youtubevideoplayer.service.LinkService;
import org.fasttrackit.youtubevideoplayer.transfer.SaveLinkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<Link> createLink(@Valid @RequestBody SaveLinkRequest request){
        Link link = linkService.createLink(request);

        return new ResponseEntity<>(link, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Link> updateLink(@PathVariable long id, @Valid @RequestBody SaveLinkRequest request){
        Link link = linkService.updateLink(id, request);

        return new ResponseEntity<>(link, HttpStatus.OK);
    }
}
