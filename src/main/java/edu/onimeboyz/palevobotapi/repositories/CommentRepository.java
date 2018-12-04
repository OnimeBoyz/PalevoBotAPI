package edu.onimeboyz.palevobotapi.repositories;
import edu.onimeboyz.palevobotapi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
