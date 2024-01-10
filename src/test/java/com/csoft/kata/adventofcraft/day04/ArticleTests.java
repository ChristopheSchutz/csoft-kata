package com.csoft.kata.adventofcraft.day04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {
    Article article;

    @BeforeEach
    void setUp() {
        article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
    }

    @Test
    void it_should_add_comment_when_no_comments () throws CommentAlreadyExistException {
        article.addComment("Amazing article !!!", "Pablo Escobar");

        Assertions.assertThat(article.getComments()).hasSize(1);
        Assertions.assertThat(article.getComments().get(0).text()).isEqualTo("Amazing article !!!");
        Assertions.assertThat(article.getComments().get(0).author()).isEqualTo("Pablo Escobar");
    }

    @Test
    void it_should_add_comment_to_existing_comment () throws CommentAlreadyExistException {
        article.addComment("Amazing article !!!", "Pablo Escobar");
        article.addComment("Even more amazing article !!!", "Pablo Escobar");

        Assertions.assertThat(article.getComments()).hasSize(2);
    }

    @Test
    void it_should_throw_an_exception_when_adding_existing_comment() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );

        assertThatThrownBy(() -> {
            article.addComment("Amazing article !!!", "Pablo Escobar");
            article.addComment("Amazing article !!!", "Pablo Escobar");
        }).isInstanceOf(CommentAlreadyExistException.class);
    }
}