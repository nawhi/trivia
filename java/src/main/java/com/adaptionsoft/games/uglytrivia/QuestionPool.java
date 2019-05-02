package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionPool {
    private List<Category> categories;

    public QuestionPool(String... categories) {
        this.categories = Arrays.stream(categories)
                .map(this::createNewQuestionsForCategory)
                .collect(Collectors.toList());
    }

    private Category createNewQuestionsForCategory(String categoryName) {
        Category questionsForCategory = new Category(categoryName);
        IntStream.range(0, 50).forEach(i -> questionsForCategory.addQuestion());
        return questionsForCategory;
    }

    public String questionFor(String category) {
        return categories.stream()
                .filter(questionsForCategory -> questionsForCategory.hasName(category))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .nextQuestion();
    }
}