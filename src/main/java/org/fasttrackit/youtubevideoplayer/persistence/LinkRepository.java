package org.fasttrackit.youtubevideoplayer.persistence;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Page<Link> findByLinkContaining(String partialLink, Pageable pageable);

    Page<Link> findByLinkContainingAndTitleContaining(String partialLink, String partialTitle, Pageable pageable);

    //JPQL syntax
    @Query(value = "SELECT link FROM Link link WHERE " +
            "(:partialTitle IS null OR link.title = :partialTitle) AND " +
            "(:partialImageUrl IS null OR link.imageUrl = :partialImageUrl)")
    Page<Link> findByOptionalCriteria(String partialTitle, String partialImageUrl, Pageable pageable);


}
