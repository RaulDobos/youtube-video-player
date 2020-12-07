package org.fasttrackit.youtubevideoplayer.web;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.fasttrackit.youtubevideoplayer.service.LinkService;
import org.fasttrackit.youtubevideoplayer.transfer.GetLinkRequest;
import org.fasttrackit.youtubevideoplayer.transfer.SaveLinkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/{id}")
    public ResponseEntity<Link> getLink(@PathVariable long id){
        Link link = linkService.getLink(id);

        return new ResponseEntity<>(link, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Link>> getLinks(@Valid GetLinkRequest request, Pageable pageable){
        Page<Link> links = linkService.getLinks(request, pageable);

        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLink(@PathVariable long id){
        linkService.deleteLink(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

