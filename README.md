# Codility

[![Build Status](https://travis-ci.org/YaroslavHavrylovych/codility.svg?branch=development)](https://travis-ci.org/YaroslavHavrylovych/codility)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

*Read in [Українська](README-UK.md)*

This repo holds solved coder problems which I did out of curiosity, at the process
of interview preparation, or even during the interview.
Each algorithm has at least Java implementation and additionally can have
Haskell or Kotlin.

Exists a vast amount of methods to group algorithms. My way is based on
[InterviewBit](https://www.interviewbit.com/courses/programming/)
and [Hackerrank](https://www.hackerrank.com/dashboard)

Some tasks have additional README which shows alternative solving methodologies,
interesting things about the task or applied usage of it.

## Preparing for an interview?

DSA is mostly recalled just before (or even at the time) an interview.
If you have to prepare ASAP, I would suggest solving a few problems from each section
on [InterviewBit](https://www.interviewbit.com/courses/programming/)
or [hackerrank](https://www.hackerrank.com/dashboard). 
This will warm you up, or give a fast overview of available methods of problems solving.
When you're done with that, you can continue there or switch to [leetcode](https://leetcode.com/), [e-olymp](https://www.e-olymp.com/uk/)
etc.

## Environment

* Java/javac - openJDK 11.0.1
* ghci (haskell runtime) - ghci version 8.2.2
* Kotlin/kotlinc - Kotlin version 1.3.21

## How to Run?

_Java_

build: `javac *.java`

run: `java filename`

_Kotlin_

build: `kotlinc *.kt -include-runtime -d output_file.jar`

run: `java -jar output_file.jar`

_Haskell_

build: `ghc -o output_file input_file.hs`

run: `./output_file`

**Bulk**

The *scripts* folder, from the root dir, contains:

`java_run.sh` - build and run for all Java files. 

`kotlin_run.sh` - build and run for all Kotlin files.

`haskell_run.sh` - build and run for all Haskell files.

`clean.sh` - clean the output directory.

Each script can have a single parameter which acts as a filter:

`java_run.sh bubble` - build and run all Java files, which have 
*bubble* in a path or a file name.
