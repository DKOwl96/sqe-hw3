# Assignment 3: Software Quality Engineering
This is a repository for assignment 3 of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called prestashop (https://address-of-the-project.com).

PrestaShop offers you a highly flexible and scalable ecommerce platform to launch an online business 100% owned and designed by you.

## Installation
we recommend installing it throw docker
to install the docker follow this link: https://www.docker.com/products/docker-desktop/
and then you can follow the installations in this links, to install prestashop: 
https://webkul.com/blog/running-prestashop-in-docker-container/
https://hub.docker.com/r/prestashop/prestashop/
Also there is very nice youtube tutorial:
https://www.youtube.com/watch?v=J4lq2eW_npE&ab_channel=PatriTech


## What we tested

We tested the Product Comments module that allows users to review products. We chose to test the following user stories: 

*User story:* A user comments on product

*Preconditions:* the user logged in

*Expected outcome:* The comment submitted

*User story:* An admin disables the commenting

*Preconditions:* the admin logged in

*Expected outcome:* The module disabled
$$

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a BDD testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 


  