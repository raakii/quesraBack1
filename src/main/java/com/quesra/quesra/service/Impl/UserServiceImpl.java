package com.quesra.quesra.service.Impl;

import com.quesra.quesra.domain.Question;
import com.quesra.quesra.domain.Space;
import com.quesra.quesra.domain.User;
import com.quesra.quesra.dto.ConnectDto;
import com.quesra.quesra.dto.LikeDto;
import com.quesra.quesra.dto.SpaceDto;
import com.quesra.quesra.repository.QuestionRepository;
import com.quesra.quesra.repository.SpaceRepository;
import com.quesra.quesra.repository.UserRepository;
import com.quesra.quesra.service.QuestionService;
import com.quesra.quesra.service.UserService;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final SpaceRepository spaceRepository;
    private final QuestionRepository questionRepository;

    private final QuestionService questionService;

    public UserServiceImpl(UserRepository userRepository, SpaceRepository spaceRepository,
                           QuestionRepository questionRepository, QuestionService questionService) {
        this.userRepository = userRepository;
        this.spaceRepository = spaceRepository;
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }

    @Override
    public User saveUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(long id, User user) {

        User existingUser = userRepository.getOne(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);

    }

    @Override
    public User connectUser(ConnectDto user) {
        try {
            User existedUser = userRepository.findByEmail(user.getEmail());
            System.out.println("salut");
            System.out.println(existedUser);

            boolean b = BCrypt.checkpw(user.getPassword(), existedUser.getPassword());
            System.out.println("Email : " + user.getEmail());
            if(!b) throw new RuntimeException("invalid email or password");
            return existedUser;


        }
        catch (Exception e){
            throw new RuntimeException("invalid email or password");
        }
    }

    @Override
    public void delete(long id) {
        User existingUser = userRepository.getOne(id);
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User joinSpace(SpaceDto spaceDto) {
        User currentUser = userRepository.findByEmail(spaceDto.getEmail());
        List<Space> joinedSpaces = currentUser.getJoindedSpaces();
        joinedSpaces.add(spaceRepository.findSpaceByName(spaceDto.getName()));
        currentUser.setJoindedSpaces(joinedSpaces);
        return userRepository.save(currentUser);
    }

    @Override
    public User unjoinSpace(SpaceDto spaceDto) {
        User currentUser = userRepository.findByEmail(spaceDto.getEmail());
        List<Space> joinedSpaces = currentUser.getJoindedSpaces();
        joinedSpaces.remove(spaceRepository.findSpaceByName(spaceDto.getName()));
        currentUser.setJoindedSpaces(joinedSpaces);
        return userRepository.save(currentUser);
    }

    @Override
    public Question likeApost(LikeDto likeDto) {
        Question question = questionRepository.findById(likeDto.getPostId()).get();
        List<User> postLikes = question.getLikes();

        if(questionService.isLiked(likeDto.getPostId(), likeDto.getUserId())) {
            postLikes.remove(userRepository.findById(likeDto.getUserId()).get());
            question.setLikes(postLikes);
        }
        else {
            postLikes.add(userRepository.findById(likeDto.getUserId()).get());
            question.setLikes(postLikes);
        }

        return questionRepository.save(question);
    }


}
