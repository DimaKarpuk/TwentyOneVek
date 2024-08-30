# Проект по автоматизации тестирования для сайта [<img width="20%" title="21Vek" src="media/logo/21vek.png"/>](https://www.21vek.by/)
> 21vek.by — это крупнейший белорусский онлайн-гипермаркет непродовольственных товаров с огромным выбором товаров.
---

# 🧾 Содержание:
- <a href="#tools">Технологии и инструменты</a>
- <a href="#checking">Тестовые сценарии, реализованные в автоматизированных тест-кейсах</a>
- <a href="#jenkins">Сборка в Jenkins</a>
- <a href="#console">Запуск тестов (Из терминала)</a>
- <a href="#allureReport">Allure-отчет</a>
- <a href="#allure">Интеграция с Allure TestOps</a>
- <a href="#teleg"> Уведомление в Telegram о результатах выполнения автоматизированных тестов</a>
- <a href="#gif"> Пример видео запуска теста</a>
---

- Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/), c применением паттерна Page Object.
- Сборщик - <code>Gradle</code>.
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
- В отчетах Allure для каждого теста (запускаемого удаленно) прикреплено видео прохождения теста.
---

<a id="tools"></a>

## 🔨 Технологии и инструменты:

<p align="left">
<a href="https://allurereport.org/"> <img src="media/logo/Allure_Report.svg" title="Appium" alt="Appium" width="40" height="40"/> </a>
<a href="https://selenide.org/"> <img src="media/logo/Selenide.svg" title="Appium" alt="Appium" width="40" height="40"/> </a>
<a href="https://qameta.io/"> <img src="media/logo/allureTe.svg" title="Appium" alt="Appium" width="40" height="40"/> </a>
<a href="https://www.w3schools.com/java/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/> </a> 
<a href="https://www.jetbrains.com/idea/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" title="IntelliJ Idea" alt="IntelliJ Idea" width="40" height="40"/> </a> 
<a href="https://git-scm.com/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/git/git-original.svg" title="Git" alt="Git" width="40" height="40"/> </a> 
<a href="https://junit.org/junit5"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" title="JUnit5" alt="JUnit5" width="40" height="40"/> </a>
<a href="https://gradle.org"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" title="Gradle" alt="Gradle" width="40" height="40"/> </a>
<a href="https://www.jenkins.io"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" title="Jenkins" alt="Jenkins" width="40" height="40"/> </a>
</p>

---
<a id="checking"></a>
## :clipboard: Тестовые сценарии

- [x] Тест на добавление товара в корзину
- [x] Тест на добавление товара в избранное
- [x] Негативный тест на авторизацию без email
- [x] Негативный тест на авторизацию без пароля
- [x] Тест на удаление товара из избранное
- [x] Тест на удаление товара из корзины
- [x] Тест кликабельности котегорий главного меню (@ParameterizedTest)
---

<a id="jenkins"></a>
## <img src="media/logo/jenkins-original.svg" width="25" height="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/KarpukD_27_TwentyOneVek/)

<p align="center">
<img src="media/screen/jenkins.png" alt="Jenkins Page" width="1000" height="350">
</p>

---

<a id="console"></a>
## :rocket: Команды для запуска

### Локальный запуск

```bash
gradle clean test -DbrowserHost=local
```

### Удаленный запуск (для запуск через selenoid нужно ввести адрес удаленного сервера)

```bash
gradle clean test -DbrowserHost=remote
-DremoteUrl= 
```
---

<a id="allureReport"></a>
## <img alt="Allure" height="25" src="media/logo/Allure_Report.svg" width="25"/> </a>Интеграция с <a target="_blank" href="https://jenkins.autotests.cloud/job/KarpukD_27_TwentyOneVek/15/allure/">Allure Report</a>

## 🖨️ Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screen/allure.png" width="850">  
</p>  

## 📄 Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screen/allure1.png" width="850">   
</p>

---

<a id="allure"></a>
## <img alt="Allure_TO" height="25" src="media/logo/allureTe.svg" width="25"/> </a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/4392/dashboards">Allure TestOps</a>

## 🖨️ Основная страница отчёта

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/screen/allureT.png" width="850">  
</p>  

## 📄 Авто тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screen/alluret2.png" width="850">  
</p>

---

<a id="teleg"></a>
## <img src="media/logo/Telegram_2019_Logo.svg" width="25" height="25"/> Уведомления в Telegram чат с ботом

### Уведомление через чат бот

<p align="center">
<img src="media/screen/telegram.jpg" alt="Telegram" width="430" height="400">
</p>


#### Содержание уведомления в Telegram

- :heavy_check_mark: Окружение
- :heavy_check_mark: Комментарий
- :heavy_check_mark: Длительность прохождения тестов
- :heavy_check_mark: Общее количество сценариев
- :heavy_check_mark: Процент прохождения тестов
- :heavy_check_mark: Ссылка на Allure отчет
---

<a id="gif"></a>
####  Пример видео запуска теста
<p align="center">
  <img src="media/gif/testVideo.gif">
</p>