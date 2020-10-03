package org.fasttrackit.youtubevideoplayer.persistence;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Page<Link> findByLinkContaining(String partialLink, Pageable pageable);

    Page<Link> findByLinkContainingAndTitleContaining(String partialLink, String partialTitle, Pageable pageable);
}
