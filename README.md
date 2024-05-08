# Project: nifty-meals app

## Background:
The goal is to build a full-stack application that supports healthy eating through high-quality meal kit services with delicious weekly menus. The application would be designed using React framework for TypeScript on the frontend to display information and take input, and Spring framework for Java on the backend, to manage persisted information.

In this app, there would be three possible categories named “Breakfast”, “Lunch” and “Dinner.” All users would be able to search for specific meals, see featured meal in a carousel, review meals and lots more. Each user gets to select one to ten meal kits per box per week. Weekly menus can be chosen from any of the three categories. To get more information about a meal kit, users must be authenticated. These delicious meal kits would then be delivered for the upcoming week. Think of companies such as Hello Fresh, Purple Carrot or Factor Meals.

Other features to be enacted will be the use of Okta in authentication and authorization as well as the setup of https certifications, keys and cross origin resource sharing.

# User Stories:
## 1: Generate scripts to manage the database
As a user, I should be able to access the database in order to view recipes, make a selection and leave reviews
### Features:
- Generate scripts to add meals into a database
- Create new tables for the DB, with names: Meal, Cart, Reviews

## 2: There should be a home page on the app - backend
As a user, I should be able to view the home page on the endpoint GET <secure-url>/home on the backend
### Features:
- Set up a backend app
- Set up a repository to get all meals in the api
- Set up configuration to have read-only functionality for the home page

## 3: Establish secure communication on the application
As a user, I should be able to have a secure communication on the app in order to encrypt data between the web browser and the application server
### Features:
- Generate key and self-signed certificate
- Create a .env file
- Set up the backend app to use the secure url
- Run the frontend app with the key and certificate

## 4: Establish authentication and authorization in the app
As a user, I should be able to restrict access to some resources in the application. This would encourage guests to become a member in order to gain access resources, other than viewing
### Features:
- Signup for Okta
- Set up Okta for authentication, access token, etc
- Set up Open ID Connect Client for the frontend
- Set up app configuration for the frontend
- Download authentication dependencies for the frontend
- Develop login and logout widgets
- Add configurations, routes and security routes to the frontend
- Add logout functionality to the frontend
- Install Okta dependency for the backend
- Set up app security configuration for the backend
- Set up token extraction for the backend

## 5: There should be a home page on the app - frontend
As a guest, I should be able to access the home page of the application which has routes for a navigation bar, a section to explore top meals, a carousel, success stories and a footer, on the frontend
### Features:
- Set up a frontend app
- Add bootstrap and css
- Display the home page
- Display routes for navbar, top meals, carousel, success stories and footer

## 6 - 9:
As a guest, I should be able to see most services of the app from the home page and navigate to those pages from the home page. Services to be displayed are ## 6 - navigation bar and footer, ##7 - explore top meals, ## 8 - success stories and ## 9 - carousel on the front end, in order to view their contents
### Features:
- Display all pages as requested
- Display a loading spinner
- Display error messages where applicable

## 10:
As a user, I should be able to find meals in the database, based on words contained in the title. This would make meals available in the api with titles that contain the word searched. Such api should include pagination
### Features:
- Set up a repository to find meals based on words found in the title

## 11:
As a guest, I should be able to search for a meal on the frontend, based on words contained in a title, and get results separated into pages. This would enable me to see what meals are available in order to make a selection
### Features:
- Display the search box on the home page
- Display pagination of meals obtained from the search request

## 12:
As a user, I should be able to find meals in the database, based on category. This would make meals available in the api based on the categories available. There are three possible categories, namely: breakfast, lunch and dinner
### Features:
- Set up a repository to find meals by category

## 13:
As a guest, I should be able to click on a dropdown next to the search button and get all available categories. I should then be able to make a category selection. After selecting a category, I should be able to search for a meal in the search box, based on a selected category and get meals associated with that category
### Features:
- Display a dropdown with all possible categories, including an option for all categories
- Display all meals associated with the category selected

## 14
As a user, I should be able to view my current meals selected for an order in the database. This would give me the necessary endpoint to be called by the ui
### Features:
- Set up a repository that would find meals from selected meals
- Provide an endpoint to obtain a list of selected meals from an endpoint

## 15:
As an authenticated user, I should be able to add a meal to cart on the front end. This would allow me to checkout one to ten meals
### Features:
- Click on an Add to Cart button
- Display a checkout page
- Validate that no more than nine meals have been selected
- Display text to indicate that the meal is available
- Display a select meal button or display text that a meal has already been selected

## 16:
As a user, I should be able to find reviews in the database in order to gain access to reviews left by authenticated users
### Features:
- Set up a repository to find reviews for a specific meal, including pagination
- Set up configuration to have read-only functionality for reviews


## 17:
As an authenticated user, I should be able to leave a star rating for a selected meal on the frontend. I should also be able to leave a review comment to explain my chosen rating score. This will allow future customers to get an impression of the meal from other buyers
### Features:
- Display rating scores using stars
- Display a review box for optional comments to go along a score
- Display latest reviews shared by reviewers

## 18:
As a user, I should be able to leave a review and have it saved in the database. This would allow me to find such reviews later
### Features:
- Set up the functionality to post a review
- Validate that a user has left a review
- Set up configuration to require authentication before leaving a review

## 19:
As an authenticated user, I should be able to leave a review on the frontend. Once I leave a review, a message should be displayed thanking me for my review. This would allow customers to give feedback about meals purchased
### Features:
- Display a dropdown with all possible review star selections
- Display a message thanking members for their reviews
- Display a box to allow for an optional message to be left along with star reviews
- Display review in the latest reviews section along with the star rating

## 20:
As a guest, I should be able to view all reviews for any specific meal on the frontend. This would help me make a decision regarding selecting a meal or not, based on what others have to say about it
### Features:
- Display a button to view all reviews for a meal
- Display a page containing all reviews for the selected meal
- Implement pagination for the reviews viewed

## 21:
As an authenticated user, I should be able to view my current meals selected for an order on the frontend. This would give me an overview of what meals I would be getting in my order
### Features:
- Display a “My meals” tab in the nav bar
- Display a “My meals” page to view all selected meals in an order
- Display the ability to route to the search page from any of the meals
- Display the ability to leave a review for any of the meals selected

## 22:
As a user, I should be able to remove a meal from the list of selected meals in the database. This would help with making changes to the order
### Features:
- Set up the functionality to remove a meal from the database
- Provide an endpoint to remove a meal

## 23:
As an authenticated user, I should be able to remove a meal from the “My meals” page on the frontend. This would help me make changes to the order
### Features:
- Display a remove meal button in each meal
- Display selected meals, with the removed meal missing from the page
