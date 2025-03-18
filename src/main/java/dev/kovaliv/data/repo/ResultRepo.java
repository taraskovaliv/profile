package dev.kovaliv.data.repo;

import dev.kovaliv.data.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<Result, Integer> {
}
