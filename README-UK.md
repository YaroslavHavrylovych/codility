# Кодосфера

[![Build Status](https://travis-ci.org/YaroslavHavrylovych/codility.svg?branch=development)](https://travis-ci.org/YaroslavHavrylovych/codility)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

*Читати [English](README.md)*

Репозиторій містить набір задач з програмування, які я робив із цікавості,
задля підготовки на співбесіди, на співбесідах і т.п. 
Кожна вправа реалізовано мінімум на java, можливі реалізації на haskell чи kotlin.

Є безліч способів комбінувати задачі у групи. Свій підхід я знайшов під час взаємодії з ресурсами
[InterviewBit](https://www.interviewbit.com/courses/programming/)
і [hackerrank](https://www.hackerrank.com/dashboard):

Деякі задачі міститимуть додаткову README інформацію, де ви зможете дізнатись
альтернативні методи вирішення задачі, цікаві аспекти рішення, чи прикладного використання.

## Серйозна співбесіда?

Більшість людей повторює структури даних і алгоритми прямо перед (чи навіть під час) проходженням співбесіди.
Якщо вам потрібно терміново підготуватись, то я радив би виконувати по парі задач
з кожної секції на таких ресурсах як 
[InterviewBit](https://www.interviewbit.com/courses/programming/)
чи [hackerrank](https://www.hackerrank.com/dashboard). Це допоможе розім'ятись,
або отримати огляд наявних підходів до вирішення питань. Далі вже
можете покращувати свої навички на там же, чи на 
[leetcode](https://leetcode.com/), [e-olymp](https://www.e-olymp.com/uk/)
і т.п.

## Середовище виконання

* Java/javac - openJDK 11.0.1
* ghci (haskell runtime) - ghci version 8.2.2
* Kotlin/kotlinc - Kotlin version 1.3.21

## Як запустити?

_Java_

збірка: `javac *.java`

запуск: `java filename`

_Kotlin_

збірка: `kotlinc *.kt -include-runtime -d output_file.jar`

запуск: `java -jar output_file.jar`

_Haskell_

збірка: `ghc -o output_file input_file.hs`

запуск: `./output_file`

**Гуртовий запуск**

Директорія *scripts*, із кореня проекту, містить:

`java_run.sh` - збірка і тестування всіх наявних Java файлів

`kotlin_run.sh` - збірка і тестування всіх наявних Kotlin файлів 

`haskell_run.sh` - збірка і тестування всіх наявних Haskell файлів

`clean.sh` - для очистки директорії збірки

Кожен скрипт може приймати параметр, який виступить фільтром для файлів:

`java_run.sh bubble` - виконає збірку і тестування java файлів, як містять
*fibo* у шляху чи назві файлу.
