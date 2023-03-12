package com.oro.model1.initializer;

import com.oro.model1.entity.*;
import com.oro.model1.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final CarPartRepository carPartRepository;

    private final CarModelRepository carModelRepository;

    private final TransactionRepository transactionRepository;

    private final UserProfileRepository userProfileRepository;

    private final List<Category> categoryList = new ArrayList<>();

    private final List<CarPart> carPartList = new ArrayList<>();

    private final List<CarModel> carModelList = new ArrayList<>();

    private final List<Transaction> transactionList = new ArrayList<>();

    private final List<UserProfile> userProfileList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        initializeCategories();
        initializeCarParts();
        initializeCarModels();
        initializeUserProfiles();
        initializeTransactions();

        categoryRepository.saveAll(categoryList);
        carPartRepository.saveAll(carPartList);
        carModelRepository.saveAll(carModelList);
        userProfileRepository.saveAll(userProfileList);
        transactionRepository.saveAll(transactionList);
    }

    private void initializeCategories() {
        categoryList.addAll(Arrays.asList(
                createCategory(1L, "Category1"),
                createCategory(2L, "Category2"),
                createCategory(3L, "Category3")
            )
        );
    }

    private void initializeCarParts() {
        carPartList.addAll(Arrays.asList(
                createCarPart(1L, "CarPart1", 1000, 1000, categoryList.get(0)),
                createCarPart(2L, "CarPart2", 2000, 2000, categoryList.get(1)),
                createCarPart(3L, "CarPart3", 3000, 3000, categoryList.get(2))
            )
        );
    }

    private void initializeCarModels() {
        carModelList.addAll(Arrays.asList(
                createCarModel(1L, "CarModel1", carPartList.get(0)),
                createCarModel(2L, "CarModel2", carPartList.get(1)),
                createCarModel(3L, "CarModel3", carPartList.get(2))
            )
        );
    }

    private void initializeUserProfiles() {
        userProfileList.addAll(Arrays.asList(
                createUserProfile(1L, "email1@gmail.com", "password1", "firstname1", "lastname1", 21),
                createUserProfile(2L, "email2@gmail.com", "password2", "firstname2", "lastname2", 22),
                createUserProfile(3L, "email3@gmail.com", "password3", "firstname3", "lastname3", 23)
            )
        );
    }

    private void initializeTransactions() {
        transactionList.addAll(Arrays.asList(
                createTransaction(1L, carPartList.get(0).getUnitPrice().multiply(BigDecimal.valueOf(5)), 5, userProfileList.get(0), carPartList.get(0)),
                createTransaction(2L, carPartList.get(1).getUnitPrice().multiply(BigDecimal.valueOf(10)), 10, userProfileList.get(1), carPartList.get(1)),
                createTransaction(3L, carPartList.get(2).getUnitPrice().multiply(BigDecimal.valueOf(15)), 15, userProfileList.get(2), carPartList.get(2))
            )
        );
    }

    private Category createCategory(long id, String name) {
        return Category.builder().id(id).name(name).build();
    }

    private CarPart createCarPart(long id, String name, int amount, int unitPrice, Category category) {
        return CarPart.builder().id(id).name(name).amount(amount).unitPrice(BigDecimal.valueOf(unitPrice)).category(category).build();
    }

    private CarModel createCarModel(long id, String name, CarPart carPart) {
        return CarModel.builder().id(id).name(name).carPart(carPart).build();
    }

    private UserProfile createUserProfile(long id, String email, String password, String firstname, String lastname, int age) {
        return UserProfile.builder().id(id).email(email).password(password).firstname(firstname).lastname(lastname).age(age).build();
    }

    private Transaction createTransaction(long id, BigDecimal cost, int amount, UserProfile userProfile, CarPart carPart) {
        return Transaction.builder().id(id).cost(cost).amount(amount).userProfile(userProfile).carPart(carPart).build();
    }
}
