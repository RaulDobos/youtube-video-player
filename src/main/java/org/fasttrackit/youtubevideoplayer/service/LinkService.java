package org.fasttrackit.youtubevideoplayer.service;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.fasttrackit.youtubevideoplayer.persistence.LinkRepository;
import org.fasttrackit.youtubevideoplayer.transfer.SaveLinkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link createLink(SaveLinkRequest request){
        //todo replace with logger
        System.out.println("Creating link: " + request);
        Link link = new Link();
        link.setLink(request.getLink());
        link.setTitle(request.getTitle());
        link.setImageUrl(request.getImageUrl());
        link.setTime(request.getTime());

        return linkRepository.save(link);
    }
}
