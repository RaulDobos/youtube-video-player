package org.fasttrackit.youtubevideoplayer.service;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.fasttrackit.youtubevideoplayer.exception.ResourceNotFoundException;
import org.fasttrackit.youtubevideoplayer.persistence.LinkRepository;
import org.fasttrackit.youtubevideoplayer.transfer.GetLinkRequest;
import org.fasttrackit.youtubevideoplayer.transfer.SaveLinkRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkService.class);

    private final LinkRepository linkRepository;

    //dependency injection
    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link createLink(SaveLinkRequest request){
        LOGGER.info("Creating link {}", request);
        Link link = new Link();
        link.setLink(request.getLink());
        link.setTitle(request.getTitle());
        link.setImageUrl(request.getImageUrl());
        link.setTime(request.getTime());
        return linkRepository.save(link);
    }

    public Link getLink(long id){
        LOGGER.info("retrieving link {}", id);
        //Optional<Link> linkOptional = linkRepository.findById(id);

//        if(linkOptional.isPresent()){
//            return linkOptional.get();
//        }
//        else{
//            throw new ResourceNotFoundException("Link " + id + " not found.");
//        }

        return linkRepository.findById(id)
                 // Lambda expression
                .orElseThrow(() -> new ResourceNotFoundException("Link " + id + " not found."));
    }

    public Page<Link> getLinks(GetLinkRequest request, Pageable pageable) {
        if(request.getPartialLink() != null && request.getPartialTitle() != null){
            return linkRepository.findByLinkContainingAndTitleContaining(
                    request.getPartialLink(), request.getPartialTitle(), pageable);
        } else if (request.getPartialLink() != null) {
            return linkRepository.findByLinkContaining(request.getPartialLink(), pageable);
        } else {
            return linkRepository.findAll(pageable);
        }
    }

    public Link updateLink(long id, SaveLinkRequest request){
        LOGGER.info("Updating link {}: {}", id, request);

        Link link = getLink(id);

        BeanUtils.copyProperties(request, link);

        return linkRepository.save(link);

    }

    public void deleteLink(long id){
        LOGGER.info("Deleting link {}", id);

        linkRepository.deleteById(id);
    }


}








