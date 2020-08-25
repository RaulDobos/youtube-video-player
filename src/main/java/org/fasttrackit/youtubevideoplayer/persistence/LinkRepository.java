package org.fasttrackit.youtubevideoplayer.persistence;

import org.fasttrackit.youtubevideoplayer.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {


}
