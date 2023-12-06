package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Kate");
        $("#userEmail").setValue("ek.karzaeva@yandex.ru");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Some street 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Kate"));
        $("#output #email").shouldHave(text("ek.karzaeva@yandex.ru"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Some street 2"));
    }
}