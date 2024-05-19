# Project: nifty-meals app

## Background:
The goal is to build a full-stack application that supports healthy eating through high-quality meal kit services with delicious weekly menus. The application would be designed using React framework for TypeScript on the frontend to display information and take input, and Spring framework for Java on the backend, to manage persisted information.

In this app, there would be three possible categories named “Breakfast”, “Lunch” and “Dinner.” All users would be able to search for specific meals, see featured meal in a carousel, review meals and lots more. Each userInfo gets to select one to ten meal kits per box per week. Weekly menus can be chosen from any of the three categories. These delicious meal kits would then be delivered for the upcoming week. Think of products such as Hello Fresh, Purple Carrot or Factor Meals.

# User Stories:
## 1: Generate scripts to manage the database
As a userInfo, I should be able to access the database in order to view recipes, make a selection and leave reviews
### Features:
- Generate scripts to add meals into a database
- Create new tables for the DB, with names: Meal, Cart, Reviews

## 2: There should be a home page on the app - backend
As a userInfo, I should be able to view the home page on the endpoint GET <secure-url>/home on the backend
### Features:
- Set up a backend app
- Set up a repository to get all meals in the api
- Set up configuration to have read-only functionality for the home page

## 3:
As a userInfo, I should be able to find meals in the database, based on words contained in the title. This would make meals available in the api with titles that contain the word searched. Such api should include pagination
### Features:
- Set up a repository to find meals based on words found in the title

## 4:
As a userInfo, I should be able to find meals in the database, based on category. This would make meals available in the api based on the categories available. There are three possible categories, namely: breakfast, lunch and dinner
### Features:
- Set up a repository to find meals by category

## 5:
As a userInfo, I should be able to view my current meals selected for an order in the database. This would give me the necessary endpoint to be called by the ui
### Features:
- Set up a repository that would find meals from selected meals
- Provide an endpoint to obtain a list of selected meals from an endpoint

## 6:
As a userInfo, I should be able to find reviews in the database in order to gain access to reviews left by authenticated users
### Features:
- Set up a repository to find reviews for a specific meal, including pagination
- Set up configuration to have read-only functionality for reviews

## 7:
As a userInfo, I should be able to leave a review and have it saved in the database. This would allow me to find such reviews later
### Features:
- Set up the functionality to post a review
- Validate that a userInfo has left a review

## 8:
As a userInfo, I should be able to remove a meal from the list of selected meals in the database. This would help with making changes to the order
### Features:
- Set up the functionality to remove a meal from the database
- Provide an endpoint to remove a meal

