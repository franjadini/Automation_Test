
#Author: Francisco Javier Diaz Niño 

@Test @Automation
Feature: Automation Test
    
  @Caso1
  Scenario Outline: Authentication fail when you login with an unexisting user
  Given I sucessfully load the case data "<Case ID>"
	Given I'm in My store main page
	And I navigate to the log in page	
	When I try to login with an unexisting user
	Then An authentication failed error message appear
	
	Examples:
	|Case ID|
	|1|
	|2|
	
	@Caso2
	Scenario: Register a new user
	Given I sucessfully load the case data "3"
	
	@Caso3
	Scenario: Add a product to the whislist
	Given I sucessfully load the case data "4"
	
	@Caso4
	Scenario: Search a product and validate its data
	Given I sucessfully load the case data "5"
	
	@Case5
	Scenario: Add several products to the cart
	Given I sucessfully load the case data "6"