# Проект по автоматизации тестирования для компании [<img width="20%" title="HABITICA" src="media/logo/habitica_logo.png"/>](https://habitica.com)
> Habitica — трекер задач, который совместил философию RPG и GTD(доведение дел до завершения) в своей Web-версии и приложениях для Android и iOS.
---
## :scroll: Содержание:
+ [Особенности проекта](#особенности-проекта)
+ [Используемый стек](#computer-используемый-стек)
+ [Реализованные проверки](#ballot_box_with_check-реализованные-проверки)
+ [Запуск тестов](#запуск-тестов)
    + [Локальный запуск тестов](#локальный-запуск-тестов)
    + [Удаленный запуск тестов на Selenoid и BrowserStack](#удаленный-запуск-тестов-на-Selenoid-и-BrowserStack)
+ [Сборка в Jenkins](#-сборка-в-jenkins)
+ [Интеграция с Allure Report](#-интеграция-с-allure-report)
+ [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
+ [Интеграция с Jira](#-интеграция-с-jira)
+ [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
+ [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-тестов-в-selenoid)
+ [Видео примера запуска тестов в BrowserStack](#-видео-примера-запуска-тестов-в-browserstack)
---
## Особенности проекта
- Проект состоит из UI-тестов, API и мобильных тестов на Android
- В данном проекте автотесты написаны на языке `Java`
- В качестве сборщика был использован - `Gradle`
- Использованы фреймворки `JUnit 5` и `Selenide`
- Шаблон проектирования `Page Object`
- Использование техноголии `Owner` для придания тестам гибкости и легкости конфигурации
- Возможность запуска тестов: локально, удалённо, по тегам
- Использование `Faker` для генерации данных
- Использование `Lombok` для моделей в API тестах
- Использование собственных расширений:
    - `@WithLogin` для предварительной авторизации
    - `@LoggingExtension` для дополнительного логирования тестов
- При прогоне UI тестов браузер запускается в `Selenoid`
- Возможность запуска проектов с помощью `Jenkins`
- Возможность запуска тестов напрямую из `Allure TestOps`
- Интеграция с `Jira`
- Уведомление о результатах прохождения в `Telegram`
- По итогу прохождения автотестов генерируется `Allure` отчет. Содержание отчета:
    - Шаги теста
    - Скриншот страницы на последнем шаге
    - Исходный код страницы в браузере
    - Логи консоли браузера
    - Видео выполнения автотеста
---
## :computer: Используемый стек
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg"/></a> 
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java.svg"/></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle.svg"/></a> 
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/logo/Selenide.svg"/></a> 
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg"/></a>
<a href="https://rest-assured.io"><img width="6%" title="REST-Assured" src="media/logo/RestAssured.svg"/></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg"/></a>
<a href="https://qameta.io"><img width="6%" title="Allure TestOps" src="media/logo/Allure_TO.svg"/></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg"/></a> 
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/GitHub.svg"/></a> 
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg"/></a> 
<a href="https://telegram.org/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg"/></a>  
<a href="https://app-automate.browserstack.com/"><img width="6%" title="BrowserStack" src="media/logo/Browserstack.svg"/></a>  
<a href="https://developer.android.com/studio"><img width="6%" title="Android Studio.svg" src="media/logo/Android_Studio.svg"/></a>   
<a href="https://appium.io"><img width="6%" title="Appium" src="media/logo/Appium.svg"/></a>  
<a href="https://www.atlassian.com/software/jira"><img width="6%" title="Jira" src="media/logo/Jira.svg"/></a>  
</p>   

---
## :ballot_box_with_check: Реализованные проверки:

### Web
- [x] Проверка корректной авторизации c помощью имени пользователя
- [x] Проверка корректной авторизации c помощью email
- [x] Проверка действия кнопки перехода к авторизации - "Вход"
- [x] Проверка действия кнопки перехода к регистрации - "Регистрация"
- [x] Проверка перемещения по разделам главной страницы (@ParameterizedTest)
- [x] Проверка быстрого создания задачи на главной странице
- [x] Проверка быстрого создания задачи на главной странице

### Api
- [x] Проверка корректной авторизации
- [x] Проверка невозможности авторизации без пароля
- [x] Проверка успешного получения информации о списках задач
- [x] Проверка создания новой задачи
- [x] Проверка удаления задачи

### Mobile
- [x] Проверка кнопки пропуска приветственного экрана - "skip"
- [x] Проверка действия кнопки перехода к авторизации - "LOGIN"
- [x] Проверка действия кнопки перехода к регистрации - "REGISTER"
---
## Запуск тестов

### Допустимые комбинации

```mermaid 
flowchart LR
    A(gradle) --> B(clean)
    B --> C{Выбрать тег}
    C --> D[test]
    C --> E[web]
    C --> F[api]
    C --> G[mobile]
    E --> H[-DbrowserHost=local]
    E --> I[-DbrowserHost=selenoid]
    G --> J[-DdeviceHost=browserstack]
    G --> K[-DdeviceHost=emulation]
    G --> L[-DdeviceHost=real]
```
### Локальный запуск тестов
> [!]  
> Для работы со своей учетной записью на https://habitica.com следует отредактировать файл - auth.properties  
> Для работы со своим мобильным устройством - заменить параметры в файле realMobile.properties  
> Для работы с отличным от проектного эмулятором стоит изменить параметры в файле - emulationMobile.properties

Запуск всех тестов
```
gradle clean test -DbrowserHost=local -DdeviceHost=real
```
Запуск Web тестов
```
gradle clean web -DbrowserHost=local
```
> [!]
> Если требуется передать параметры отличные от дефолтных в интерфейсе WebConfig  
> то можно изменить интерфейс, либо передать свои параметры в переменных при запуске тестов  
> Например:
>* <code>baseUrl</code> – URL.
>* <code>browser</code> – браузер, в котором будут выполняться тесты.
>* <code>browserSize</code> – размер окна браузера, в котором будут выполняться тесты.
> ```
>-DbaseUrl=https://habitica.com
>-Dbrowser=chrome
>-DbrowserSize=1920x1080
>```
Запуск API тестов
```
gradle clean api
```
Запуск мобильных тестов на реальном устройстве
```
gradle clean mobile -DdeviceHost=real
```
Запуск мобильных тестов на эмуляторе Android Studio
```
gradle clean mobile -DdeviceHost=emulation
```
> [!] Для работы с реальным или виртуальным мобильным устройством следует ознакомиться с данной инструкцией
> <details>
> <summary>Инструкция</summary>
>
>#### 1. Настроить рабочий стол:
>
> Вариант 1:   
>https://autotest.how/appium-setup-for-local-android-tutorial-md
>
>Вариант 2:   
>Установить android studio https://developer.android.com/studio   
>Прописать настройки:
>
>Параметры Path:
>
>Windows:   
>%ANDROID_HOME%\tools   
>%ANDROID_HOME%\tools\bin   
>%ANDROID_HOME%\platform-tools
>%ANDROID_HOME%\emulator
>
>Одной строкой, можно скопировать и в командной строке прописать:
>```shell
>setx PATH %PATH%;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools;%ANDROID_HOME%\emulator
>```
>
>Mac:  
>export ANDROID_HOME=/Users/stanislav/Library/Android/sdk   
>export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools   
>source ~/.bash_profile
>- В Android Studio -> SDK Manager скачать 11 андроид (если не скачан по умолчанию)
>- В AVD Manager скачать образ Pixel 4 для 11 андроида (если не скачан по умолчанию)   
   >  -- Запустить эмулятор телефона, опробовать кнопки и функционал
>- Установить node.js - https://nodejs.org/en/download
>- Установить Appium Server https://github.com/appium/appium
>
>Mac:
>```shell
>sudo npm install -g appium@next
>```    
>Windows:
>```shell
>npm install -g appium
>```
>
>- Установить драйвер uiautomator2   
   >  Mac:
>```shell
> sudo appium driver install --source=npm uiautomator2 (если команда не подходит - можно выполнить эту appium driver install uiautomator2)
>```   
>Windows:
> ```shell
 >appium driver install --source=npm uiautomator2 (если команда не подходит - можно выполнить эту appium driver install uiautomator2)
>```  
>
>- Установить Appium Ispector https://github.com/appium/appium-inspector
>- Запустить Appium Server
>```shell
>appium server --base-path /wd/hub
>```
>#### 2. Открыть Appium Inspector
>**Подключить локальное устройство:**   
>Для определения серийного номера устройства
>```shell
>cd C:\Users\{User}\AppData\Local\Android\Sdk\platform-tools
>```
>Затем ввести команду и найти serial_number устройства
>```shell
>adb devices
>```
>В Appium Inspector в теле сессии ввести:
>```shell
>{
>  "platformName": "Android",
>  "appium:automationName": "UiAutomator2",
>  "appium:deviceName": "{serial_number}"
>}
>```
>**Для подключения к эмуляции ввести данные от виртуального устройства**
></details>
### Удаленный запуск тестов на Selenoid и BrowserStack
> [!] В проекте запуск Web тестов на Selenoid и мобильных тестов на BrowserStack установлен поумолчанию
>
> Для работы со своей учетной записью на https://app-automate.browserstack.com следует отредактировать файл - auth.properties.  
> Если требуется изменить устройство следует отредактировать файл - browserstackMobile.properties.

Запуск всех тестов
```
gradle clean test
```
Запуск Web тестов на Selenoid
```
gradle clean web 
```
или
```
gradle clean web -DbrowserHost=selenoid
```
> [!]
> Если требуется передать параметры отличные от дефолтных в интерфейсе WebConfig  
> то можно изменить интерфейс, либо передать свои параметры в переменных при запуске тестов  
> Например:
>* <code>baseUrl</code> – URL.
>* <code>browser</code> – браузер, в котором будут выполняться тесты.
>* <code>browserVersion</code> – версия браузера, в которой будут выполняться тесты.
>* <code>browserSize</code> – размер окна браузера, в котором будут выполняться тесты.
> ```
>-DbaseUrl=https://habitica.com
>-Dbrowser=chrome
>-DbrowserVersion=100
>-DbrowserSize=1920x1080

>```
Запуск мобильных тестов на BrowserStack
```
gradle clean mobile 
```
или
```
gradle clean mobile -DdeviceHost=browserstack
```
---

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/27-AnBrain-unit23-Habitica_Tests_Project)

* <code>TASK</code> – название запускаемой задачи. По умолчанию - <code>test</code>.
* <code>BASE_URL</code> – URL. По умолчанию - <code>https://habitica.com</code>.
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию - <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию - <code>1920x1080</code>.

***Параметры запуска:***
```bash  
clean ${TASK}
-"DbaseUrl=${BASE_URL}"
-"Dbrowser=${BROWSER}"
-"DbrowserSize=${BROWSER_SIZE}"
-"DbrowserVersion=${BROWSER_VERSION}"
```
Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code>, задать параметры и нажать кнопку <code>Собрать</code>.
<p align="center">
<img title="Jenkins Build" src="media/screens/Jenkins1.jpg">
<img title="Jenkins Build" src="media/screens/Jenkins2.jpg">
</p>
После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значек <code>Allure Report</code>, при клике на который откроется страница со сформированным html-отчетом и тестовой документацией соответственно,
а так же появятся значек <code>Allure TestOps</code> при клике на который откроется страница проекта в <code>Allure TestOps</code>.

---
## <img width="4%" style="vertical-align:middle" title="Allure_Report" src="media/logo/Allure_Report.svg"> Интеграция с [Allure Report](https://jenkins.autotests.cloud/job/27-AnBrain-unit23-Habitica_Tests_Project/6/allure/)
`ALLURE REPORT` - отображает дату и время теста, общее количество запущенных тестов, а также диаграмму с процентом и количеством успешных, упавших и сломавшихся в процессе выполнения тестов  
`TREND` - отображает тенденцию выполнения тестов для всех запусков  
`SUITES` - отображает распределение тестов по сьютам  
`CATEGORIES` - отображает распределение неудачных тестов по типам дефектов

### Диаграмма прохождения тестов

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screens/allure1.jpg" width="850">  
</p>  

### Развернутый результат прохождения тестов:
1. Общий список автотестов
2. Содержание автотеста
3. Вложения

<p align="center">  
<img title="Allure Tests" src="media/screens/allure2.jpg" width="850">  
</p>

---
## <img width="4%" style="vertical-align:middle" title="Allure_TestOps" src="media/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4348)

### Дашборд

<p align="center">  
<img title="Allure Tests" src="media/screens/allureTO1.jpg" width="850">  
</p>

### Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screens/allureTO2.jpg" width="850">  
</p>

### Запуски
<p align="center">  
<img title="Allure Tests" src="media/screens/allureTO3.jpg" width="850">  
</p>

---
## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1304)

### В Jira создана задача
<p align="center">  
<img title="Allure Tests" src="media/screens/Jira1.jpg" width="850">  
</p>

### В разделе `Allure:Test Cases` отображаются тест-кейсы
<p align="center">  
<img title="Allure Tests" src="media/screens/Jira2.jpg" width="850">  
</p>

### В разделе `Allure:Launches` отображаются запуски прогонов
<p align="center">  
<img title="Allure Tests" src="media/screens/Jira3.jpg" width="850">  
</p>

---
## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/Telegram.jpg">
</p>

---
## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="media/screens/Selenoid.gif">
</p>

---

## <img width="4%" style="vertical-align:middle" title="BrowserStack" src="media/logo/Browserstack.svg"> Видео примера запуска тестов в BrowserStack

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Browserstack" src="media/screens/Browserstack.gif">
</p>
