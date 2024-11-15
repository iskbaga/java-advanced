# Тесты к курсу «Технологии Java»

[Условия домашних заданий](https://www.kgeorgiy.info/courses/java-advanced/homeworks.html)


## Домашнее задание 12. HelloNonblockingUDP

Интерфейсы

 * `HelloUDPNonblockingClient` должен реализовывать интерфейс
    [HelloClient](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/HelloClient.java)
 * `HelloUDPNonblockingServer` должен реализовывать интерфейс
    [HelloServer](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/HelloServer.java)

Тестирование

 * Базовый вариант (`client` и `server`)
 * Простой вариант (`new-client` и `new-server`)
    * `HelloUDPServer` должен реализовывать интерфейс
      [NewHelloServer](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/NewHelloServer.java)
 * Сложный вариант (`new-client-i18n` и `new-server-i18n`)
    * `HelloUDPServer` должен реализовывать интерфейс
      [NewHelloServer](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/NewHelloServer.java).
    * На противоположной стороне находится система, дающая ответы на различных языках.
 * Продвинутый вариант (`new-client-evil` и `new-server-evil`)
    * `HelloUDPServer` должен реализовывать интерфейс.
      [NewHelloServer](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/NewHelloServer.java).
    * на противоположной стороне находится старая система,
      не полностью соответствующая последней версии спецификации.

Тестовый модуль: [info.kgeorgiy.java.advanced.hello](shared/artifacts/info.kgeorgiy.java.advanced.hello.jar)

## Домашнее задание 11. Банк

Модификации
 * продвинутый вариант (`advanced`):
    добавьте поддержку переводов с одного счёта на другой.



## Домашнее задание 10. HelloUDP

Интерфейсы

 * `HelloUDPClient` должен реализовывать интерфейс
    [HelloClient](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/HelloClient.java)
 * `HelloUDPServer` должен реализовывать интерфейс
    [HelloServer](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/HelloServer.java)

Тестирование

 * Базовый вариант (`client` и `server`)
 * Простой вариант (`new-client` и `new-server`)
    * `HelloUDPServer` должен реализовывать интерфейс
      [NewHelloServer](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/NewHelloServer.java)
 * Сложный вариант (`new-client-i18n` и `new-server-i18n`)
    * `HelloUDPServer` должен реализовывать интерфейс
      [NewHelloServer](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/NewHelloServer.java).
    * На противоположной стороне находится система, дающая ответы на различных языках.
 * Продвинутый вариант (`new-client-evil` и `new-server-evil`)
    * `HelloUDPServer` должен реализовывать интерфейс.
      [NewHelloServer](shared/modules/info.kgeorgiy.java.advanced.hello/info/kgeorgiy/java/advanced/hello/NewHelloServer.java).
    * на противоположной стороне находится старая система,
      не полностью соответствующая последней версии спецификации.


## Домашнее задание 9. Web Crawler

Тесты используют только внутренние данные и ничего не скачивают из интернета.

Тестирование

 * простой вариант (`easy`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.crawler/info/kgeorgiy/java/advanced/crawler/EasyCrawlerTest.java)
 * сложный вариант (`hard`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.crawler/info/kgeorgiy/java/advanced/crawler/HardCrawlerTest.java)
 * простая модификация (`new-easy`):
    [интерфейс](shared/modules/info.kgeorgiy.java.advanced.crawler/info/kgeorgiy/java/advanced/crawler/NewCrawler.java),
    [тесты](shared/modules/info.kgeorgiy.java.advanced.crawler/info/kgeorgiy/java/advanced/crawler/NewEasyCrawlerTest.java)
 * сложная модификация (`new-hard`):
    [интерфейс](shared/modules/info.kgeorgiy.java.advanced.crawler/info/kgeorgiy/java/advanced/crawler/NewCrawler.java),
    [тесты](shared/modules/info.kgeorgiy.java.advanced.crawler/info/kgeorgiy/java/advanced/crawler/NewHardCrawlerTest.java)
 * продвинутый вариант (`advanced`):
    [интерфейс](shared/modules/info.kgeorgiy.java.advanced.crawler/info/kgeorgiy/java/advanced/crawler/AdvancedCrawler.java),
    [тесты](shared/modules/info.kgeorgiy.java.advanced.crawler/info/kgeorgiy/java/advanced/crawler/AdvancedCrawlerTest.java)


## Домашнее задание 8. Параллельный запуск

Тестирование
 * простой вариант (`scalar`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.mapper/info/kgeorgiy/java/advanced/mapper/ScalarMapperTest.java)
 * сложный вариант (`list`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.mapper/info/kgeorgiy/java/advanced/mapper/ListMapperTest.java)
 * простая модификация (`new-scalar`):
    * Класс `IterativeParallelism` должен реализовывать интерфейс
      [NewScalarIP](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/NewScalarIP.java).
    * [Тесты](shared/modules/info.kgeorgiy.java.advanced.mapper/info/kgeorgiy/java/advanced/mapper/NewScalarMapperTest.java)
 * сложная модификация (`new-list`):
    * Класс `IterativeParallelism` должен реализовывать интерфейс
      [NewListIP](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/NewListIP.java).
    * [Тесты](shared/modules/info.kgeorgiy.java.advanced.mapper/info/kgeorgiy/java/advanced/mapper/NewListMapperTest.java)
 * продвинутая модификация (`advanced`):
    * Класс `IterativeParallelism` должен реализовывать интерфейс
      [AdvancedIP](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/AdvancedIP.java).
    * [Тесты](shared/modules/info.kgeorgiy.java.advanced.mapper/info/kgeorgiy/java/advanced/mapper/AdvancedMapperTest.java)

Тестовый модуль: [info.kgeorgiy.java.advanced.mapper](shared/artifacts/info.kgeorgiy.java.advanced.mapper.jar)


## Домашнее задание 7. Итеративный параллелизм

Тестирование

 * простой вариант (`scalar`):
    * Класс должен реализовывать интерфейс
      [ScalarIP](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/ScalarIP.java).
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/ScalarIPTest.java)
 * сложный вариант (`list`):
    * Класс должен реализовывать интерфейс
      [ListIP](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/ListIP.java).
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/ListIPTest.java)
 * простая модификация (`new-scalar`):
    * Класс должен реализовывать интерфейс
      [NewScalarIP](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/NewScalarIP.java).
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/NewScalarIPTest.java)
 * сложная модификация (`new-list`):
    * Класс должен реализовывать интерфейс
      [NewListIP](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/NewListIP.java).
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/NewListIPTest.java)
 * продвинутая модификация (`advanced`):
    * Класс должен реализовывать интерфейс
      [AdvancedIP](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/AdvancedIP.java).
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.iterative/info/kgeorgiy/java/advanced/iterative/AdvancedIPTest.java)

Тестовый модуль: [info.kgeorgiy.java.advanced.iterative](shared/artifacts/info.kgeorgiy.java.advanced.iterative.jar)


## Домашние задания 5, 6. JarImplementor

Класс `Implementor` должен дополнительно реализовывать интерфейс
[JarImpler](shared/modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/JarImpler.java).

Скрипты, `MANIFEST.MF` и `.jar-файл` должны находиться в каталоге `scripts` 
в корне репозитория. 
Скомпилированный Javadoc должен находиться в каталоге `javadoc` 
в корне репозитория.

В скриптах вы можете рассчитывать на то, что репозиторий курса 
лежит рядом с вашим репозиторием в каталоге `java-advanced-2024`.

Исходный код

 * простой вариант (`jar-interface`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/InterfaceJarImplementorTest.java)
 * сложный вариант (`jar-class`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/ClassJarImplementorTest.java)
 * продвинутый вариант (`advanced`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/AdvancedJarImplementorTest.java)

Тестовый модуль: [info.kgeorgiy.java.advanced.implementor](shared/artifacts/info.kgeorgiy.java.advanced.implementor.jar)


## Домашнее задание 4. Implementor

Класс `Implementor` должен реализовывать интерфейс
[Impler](shared/modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/Impler.java).

Исходный код

 * простой вариант (`interface`): 
    [тесты](shared/modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/InterfaceImplementorTest.java)
 * сложный вариант (`class`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/ClassImplementorTest.java)

Тестовый модуль: [info.kgeorgiy.java.advanced.implementor](shared/artifacts/info.kgeorgiy.java.advanced.implementor.jar)


## Домашнее задание 3. Студенты

Исходный код

 * простой вариант (`StudentQuery`):
    [интерфейс](shared/modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/StudentQuery.java),
    [тесты](shared/modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/StudentQueryTest.java)
 * сложный вариант (`GroupQuery`):
    [интерфейс](shared/modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/GroupQuery.java),
    [тесты](shared/modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/GroupQueryTest.java)
 * продвинутый вариант (`AdvancedQuery`):
    [интерфейс](shared/modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/AdvancedQuery.java),
    [тесты](shared/modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/AdvancedQueryTest.java)


## Домашнее задание 2. ArraySortedSet

Исходный код

 * простой вариант (`SortedSet`):
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.arrayset/info/kgeorgiy/java/advanced/arrayset/SortedSetTest.java)
 * сложный вариант (`NavigableSet`):
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.arrayset/info/kgeorgiy/java/advanced/arrayset/NavigableSetTest.java)
 * продвинутый вариант (`AdvancedSet`):
    * `ArraySet` должен дополнительно реализовывать интерфейс `List`
    * Код должен собираться и работать под Java 21
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.arrayset/info/kgeorgiy/java/advanced/arrayset/AdvancedSetTest.java)

Тестовый модуль: [info.kgeorgiy.java.advanced.arrayset](shared/artifacts/info.kgeorgiy.java.advanced.arrayset.jar)


## Домашнее задание 1. Обход файлов

Исходный код

 * простой вариант (`Walk`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.walk/info/kgeorgiy/java/advanced/walk/WalkTest.java)
 * сложный вариант (`RecursiveWalk`):
    [тесты](shared/modules/info.kgeorgiy.java.advanced.walk/info/kgeorgiy/java/advanced/walk/RecursiveWalkTest.java)
 * продвинутый вариант (`AdvancedWalk`):
    * Третьим аргументом командной строки может быть задан алгоритм хеширования: `jenkins` или `sha-1`.
    * [тесты](shared/modules/info.kgeorgiy.java.advanced.walk/info/kgeorgiy/java/advanced/walk/AdvancedWalkTest.java)

Тестовый модуль: [info.kgeorgiy.java.advanced.walk](shared/artifacts/info.kgeorgiy.java.advanced.walk.jar)

Для того, чтобы протестировать программу:

 * Скачайте
    * тесты
        * [базовый модуль](shared/artifacts/info.kgeorgiy.java.advanced.base.jar)
        * [тестовый модуль](shared/artifacts/info.kgeorgiy.java.advanced.walk.jar) (свой для каждого ДЗ)
    * [библиотеки](lib)
 * Откомпилируйте решение домашнего задания
 * Протестируйте домашнее задание
    * Текущая директория должна:
       * содержать все скачанные `.jar` файлы;
       * содержать скомпилированное решение;
       * __не__ содержать скомпилированные самостоятельно тесты.
    * Запустите тесты:
        `java -cp . -p . -m <тестовый модуль> <вариант> <полное имя класса>`
    * Пример для простого варианта ДЗ-1:
        `java -cp . -p . -m info.kgeorgiy.java.advanced.walk Walk <полное имя класса>`