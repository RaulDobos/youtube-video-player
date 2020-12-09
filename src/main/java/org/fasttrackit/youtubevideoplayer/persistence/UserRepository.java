package org.fasttrackit.youtubevideoplayer.persistence;

import org.fasttrackit.youtubevideoplayer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
