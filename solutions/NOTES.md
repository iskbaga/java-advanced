* :NOTE: скрипты для генерации javadoc должны лежить в крне репозитория в директории scripts
* :NOTE: также должен быть скрипт для сборки jar c Implementor
* :NOTE: так же в репозитории должнен быть сгенерированный javadoc

```
~/IdeaProjects/test/java-advanced-private/test git:[master]
./tuna.sh ht Bagautdinov_Iskander crawler
java-advancedjava-advanced
java-advanced homework-testjava-advanced homework-test
Committing __current-repo
Текущая ветка: master
Эта ветка соответствует «origin/master».

нечего коммитить, нет изменений в рабочем каталоге
Pushing __current-repo
Everything up-to-date
Pulling __local/git/Bagautdinov_Iskander
remote: Enumerating objects: 187, done.
remote: Counting objects: 100% (187/187), done.
remote: Compressing objects: 100% (108/108), done.
remote: Total 179 (delta 46), reused 0 (delta 0)
Получение объектов: 100% (179/179), 93.19 КиБ | 1.11 МиБ/с, готово.
Определение изменений: 100% (46/46), завершено с 1 локальным объектом.
Из https://www.kgeorgiy.info/git-students/year2022/Bagautdinov_Iskander/java-advanced
   3b6a81f..b8e6f91  master     -> origin/master
Обновление 3b6a81f..b8e6f91
Fast-forward
 NOTES.md                                                                                                      |   3 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/arrayset/ArraySet.java                                            |   4 +-
 java-solutions/info/kgeorgiy/ja/bagautdinov/crawler/WebCrawler.java                                           | 156 ++++++++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/Implementor.java                                      | 240 ++++++++++++++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/MANIFEST.MF                                           |   2 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/allclasses-index.html                         |  65 +++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/allpackages-index.html                        |  63 ++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/element-list                                  |   1 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/help-doc.html                                 | 170 +++++++++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/index-all.html                                | 123 ++++++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/index.html                                    |  26 ++
 .../kgeorgiy/ja/bagautdinov/implementor/javadoc/info/kgeorgiy/ja/bagautdinov/implementor/Implementor.html     | 376 ++++++++++++++++++++++++
 .../kgeorgiy/ja/bagautdinov/implementor/javadoc/info/kgeorgiy/ja/bagautdinov/implementor/package-summary.html |  81 ++++++
 .../kgeorgiy/ja/bagautdinov/implementor/javadoc/info/kgeorgiy/ja/bagautdinov/implementor/package-tree.html    |  66 +++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/jquery-ui.overrides.css                       |  35 +++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/ADDITIONAL_LICENSE_INFO                 |  37 +++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/ASSEMBLY_EXCEPTION                      |  27 ++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/LICENSE                                 | 347 ++++++++++++++++++++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/jquery.md                               |  72 +++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/jqueryUI.md                             |  49 ++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/member-search-index.js                        |   1 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/module-search-index.js                        |   1 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/overview-tree.html                            |  70 +++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/package-search-index.js                       |   1 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/resources/glass.png                           | Bin 0 -> 499 bytes
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/resources/x.png                               | Bin 0 -> 394 bytes
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/script-dir/jquery-3.6.0.min.js                |   2 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/script-dir/jquery-ui.min.css                  |   6 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/script-dir/jquery-ui.min.js                   |   6 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/script.js                                     | 132 +++++++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/search.js                                     | 354 +++++++++++++++++++++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/stylesheet.css                                | 869 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/tag-search-index.js                           |   1 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/type-search-index.js                          |   1 +
 java-solutions/info/kgeorgiy/ja/bagautdinov/iterative/IterativeParallelism.java                               | 212 ++++++++++++++
 scripts/gen_docs.sh                                                                                           |  16 ++
 scripts/gen_jar.sh                                                                                            |  17 ++
 37 files changed, 3630 insertions(+), 2 deletions(-)
 create mode 100644 NOTES.md
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/crawler/WebCrawler.java
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/Implementor.java
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/MANIFEST.MF
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/allclasses-index.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/allpackages-index.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/element-list
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/help-doc.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/index-all.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/index.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/info/kgeorgiy/ja/bagautdinov/implementor/Implementor.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/info/kgeorgiy/ja/bagautdinov/implementor/package-summary.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/info/kgeorgiy/ja/bagautdinov/implementor/package-tree.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/jquery-ui.overrides.css
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/ADDITIONAL_LICENSE_INFO
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/ASSEMBLY_EXCEPTION
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/LICENSE
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/jquery.md
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/legal/jqueryUI.md
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/member-search-index.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/module-search-index.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/overview-tree.html
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/package-search-index.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/resources/glass.png
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/resources/x.png
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/script-dir/jquery-3.6.0.min.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/script-dir/jquery-ui.min.css
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/script-dir/jquery-ui.min.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/script.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/search.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/stylesheet.css
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/tag-search-index.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/javadoc/type-search-index.js
 create mode 100644 java-solutions/info/kgeorgiy/ja/bagautdinov/iterative/IterativeParallelism.java
 create mode 100644 scripts/gen_docs.sh
 create mode 100644 scripts/gen_jar.sh
Removing __current-repo
Copying __local/git/Bagautdinov_Iskander to __current-repo
commit b8e6f9138e4d96ed9f039bb3e8182b13d3499369
Author: iskbaga <112892889+iskbaga@users.noreply.github.com>
Date:   Fri Apr 26 14:59:20 2024 +0300

    crawler
Compiling 1 Java sources
Tests: running
WARNING: A command line option has enabled the Security Manager
WARNING: The Security Manager is deprecated and will be removed in a future release
Running class info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest for info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler
=== Running NewHardCrawlerTest.test01_singlePage()
--- NewHardCrawlerTest.test01_singlePage() finished in 48ms
=== Running NewHardCrawlerTest.test02_pageAndLinks()
--- NewHardCrawlerTest.test02_pageAndLinks() finished in 302ms
=== Running NewHardCrawlerTest.test03_invalid()
--- NewHardCrawlerTest.test03_invalid() finished in 217ms
=== Running NewHardCrawlerTest.test04_deep()
--- NewHardCrawlerTest.test04_deep() finished in 2579ms
=== Running NewHardCrawlerTest.test05_noLimits()
--- NewHardCrawlerTest.test05_noLimits() finished in 1340ms
=== Running NewHardCrawlerTest.test06_limitDownloads()
--- NewHardCrawlerTest.test06_limitDownloads() finished in 1318ms
=== Running NewHardCrawlerTest.test07_limitExtractors()
--- NewHardCrawlerTest.test07_limitExtractors() finished in 1318ms
=== Running NewHardCrawlerTest.test08_limitBoth()
--- NewHardCrawlerTest.test08_limitBoth() finished in 1323ms
=== Running NewHardCrawlerTest.test09_performance()
--- NewHardCrawlerTest.test09_performance() finished in 1322ms
=== Running NewHardCrawlerTest.test10_realTimePerformance()
--- NewHardCrawlerTest.test10_realTimePerformance() finished in 1335ms
=== Running NewHardCrawlerTest.test20_singleConnectionPerHost()
--- NewHardCrawlerTest.test20_singleConnectionPerHost() finished in 173ms
=== Running NewHardCrawlerTest.test21_limitedConnectionsPerHost()
--- NewHardCrawlerTest.test21_limitedConnectionsPerHost() finished in 171ms
=== Running NewHardCrawlerTest.test22_limitedConnectionsPerformance()
--- NewHardCrawlerTest.test22_limitedConnectionsPerformance() finished in 176ms
Test NewHardCrawlerTest.test01_singlePage() failed: url = https://en.itmo.ru/en/page/50/Partnership.htm, depth = 1, excludes = [200]
java.lang.AssertionError: url = https://en.itmo.ru/en/page/50/Partnership.htm, depth = 1, excludes = [200]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:85)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test01_singlePage(EasyCrawlerTest.java:26)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test02_pageAndLinks() failed: url = https://itmo.ru, depth = 2, excludes = [200]
java.lang.AssertionError: url = https://itmo.ru, depth = 2, excludes = [200]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:85)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test02_pageAndLinks(EasyCrawlerTest.java:32)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test03_invalid() failed: url = https://itmo.ru/ru/educational-activity/voprosi_predlojeniya.htmvoprosy_i_predlozheniya.htmvoprosy_i_predlozheniya.htm, depth = 1, excludes = [200]
java.lang.AssertionError: url = https://itmo.ru/ru/educational-activity/voprosi_predlojeniya.htmvoprosy_i_predlozheniya.htmvoprosy_i_predlozheniya.htm, depth = 1, excludes = [200]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:85)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test03_invalid(EasyCrawlerTest.java:38)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test04_deep() failed: url = http://www.kgeorgiy.info, depth = 1, excludes = [j]
java.lang.AssertionError: url = http://www.kgeorgiy.info, depth = 1, excludes = [j]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:85)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test04_deep(EasyCrawlerTest.java:44)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test05_noLimits() failed: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [200]
java.lang.AssertionError: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [200]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:94)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test05_noLimits(EasyCrawlerTest.java:50)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test06_limitDownloads() failed: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [200]
java.lang.AssertionError: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [200]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:94)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test06_limitDownloads(EasyCrawlerTest.java:55)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test07_limitExtractors() failed: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [200]
java.lang.AssertionError: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [200]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:94)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test07_limitExtractors(EasyCrawlerTest.java:60)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test08_limitBoth() failed: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [j]
java.lang.AssertionError: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [j]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:94)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test08_limitBoth(EasyCrawlerTest.java:65)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test09_performance() failed: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [j]
java.lang.AssertionError: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [j]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:94)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test09_performance(EasyCrawlerTest.java:70)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test10_realTimePerformance() failed: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [j]
java.lang.AssertionError: url = http://nerc.itmo.ru/subregions/index.html, depth = 3, excludes = [j]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:94)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test10_realTimePerformance(EasyCrawlerTest.java:75)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
Test NewHardCrawlerTest.test20_singleConnectionPerHost() failed: url = https://itmo.ru, depth = 2, excludes = [200]
java.lang.AssertionError: url = https://itmo.ru, depth = 2, excludes = [200]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.HardCrawlerTest.test20_singleConnectionPerHost(HardCrawlerTest.java:20)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 6 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 9 more
Test NewHardCrawlerTest.test21_limitedConnectionsPerHost() failed: url = https://itmo.ru, depth = 2, excludes = [200]
java.lang.AssertionError: url = https://itmo.ru, depth = 2, excludes = [200]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.HardCrawlerTest.test21_limitedConnectionsPerHost(HardCrawlerTest.java:25)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 6 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 9 more
Test NewHardCrawlerTest.test22_limitedConnectionsPerformance() failed: url = https://itmo.ru, depth = 3, excludes = [j]
java.lang.AssertionError: url = https://itmo.ru, depth = 3, excludes = [j]
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:41)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewHardCrawlerTest.test(NewHardCrawlerTest.java:18)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.EasyCrawlerTest.test(EasyCrawlerTest.java:107)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.HardCrawlerTest.testPerformance(HardCrawlerTest.java:35)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.HardCrawlerTest.test22_limitedConnectionsPerformance(HardCrawlerTest.java:30)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.AssertionError: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:36)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.download(CrawlerTask.java:53)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.test(CrawlerTask.java:68)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.NewEasyCrawlerTest.testTask(NewEasyCrawlerTest.java:35)
        ... 7 more
Caused by: java.lang.ClassCastException: Cannot cast info.kgeorgiy.ja.bagautdinov.crawler.WebCrawler to info.kgeorgiy.java.advanced.crawler.NewCrawler
        at java.base/java.lang.Class.cast(Class.java:4067)
        at info.kgeorgiy.java.advanced.crawler/info.kgeorgiy.java.advanced.crawler.CrawlerTask.createCrawler(CrawlerTask.java:34)
        ... 10 more
ERROR: Tests: failed
```