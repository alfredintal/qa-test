# qa-test
# QA Test for Humanforce

## Preface
Hi! The tool I have chosen was [Katalon](https://katalon.com/) and running these tests will require users to have the app installed. I understand that this might fall outside the requirements, but I will also show demonstrations on the video linked below on how they operate on their end. This uses groovy/Selenium as automation framework.

## User Stories and Gherkin-based ACs:


Feature: User Story #1 - Easy **(DONE)**
```
  Scenario: Navigate to 'Time & Attendance' page and read an article
    Given I am a viewer
    When I visit "https://www.humanforce.com/"
    And I navigate to the 'Time & Attendance' page
    Then I should see helpful resources at the bottom of the page
    When I select the '7 benefits of workforce analytics for business' article
    Then I should be able to read the article
```
Feature: User Story #2 - Easy **(DONE)**
```
  Scenario: Login successfully and see greeting
    Given I am an Employee with valid credentials
    When I visit "<test tenant>"
    And I log in with my credentials
    Then I should be redirected to the home page
    And I should see a greeting with my name
```
Feature: User Story #3 - Medium **(BLOCKED, THE HF ACADEMY BUTTON IS MISSING)**
```
  Scenario: Access HF Academy and read an article
    Given I am a Manager
    When I log in to "<test tenant>"
    And I click the 'HF Academy' button at the bottom left of the page
    Then a pop-up window should appear
    When I search for 'Personal'
    Then I should find an article titled 'How do I view or update my details'
    When I scroll down and select the article
    Then I should be able to read the article
    When I navigate back to the Home Page
    And I log out of the system
    Then I should be successfully logged out
```
Feature: User Story #4 - Hard **(SKIPPED)**
```
  Scenario: Create, modify, and manage Areas
    Given I am an Admin
    When I navigate to "<test tenant>/Admin/Area"
    And I add multiple new Areas
    Then I should see all created Areas listed
    When I edit an Area
    Then the changes should be saved successfully
    When I delete an Area
    Then it should no longer be listed
    When I undelete the Area
    Then it should reappear in the list
```
Feature: User Story #5 - Very Hard **(SKIPPED)**
```
  Scenario: Import Employee data from CSV file
    Given I have downloaded the CSV file and updated Employee details
    When I visit "<test tenant>/IntegrationsCentral/"
    And I add a new 'File Import' task with Data type 'Employee Basic'
    And I upload the provided CSV file
    And I proceed without making changes
    Then I should see a pop-up about File Import
    When I select 'Import Only'
    Then the system should confirm the import completion
    When I navigate to "<test tenant>/EmployeeManagement/"
    And I set the Location filter to 'All Locations'
    Then I should see the imported employee in the system
```
Feature: User Story #6 - Easy **(DONE)**
```
  Scenario: Employee is prevented from accessing Rostering Manager page
    Given I am an Employee
    When I log in and navigate to "<test tenant>/RosteringManager/"
    Then I should be prevented from viewing the content
    And I should see a message explaining the restriction
    When I navigate back to the home page
    Then I should be able to continue with my work
```
Feature: User Story #7 - Medium **(DONE)**
```
  Scenario: Send a message via chat feature
    Given I am an Admin
    When I click 'View all messages' under the MESSAGES section on the Home Page
    And I send a new message to another employee
    Then the intended recipient should be correct
    And the message should be visible in the chat box
```
Feature: User Story #8 - Easy **(DONE)**
```
  Scenario: Manager is prevented from modifying their own profile
    Given I am a Manager
    When I navigate to "<test tenant>/EmployeeManagement/"
    And I try to edit my employee profile
    Then I should see a warning message
    And I should be prevented from saving any changes
```
Feature: User Story #9 - Medium **(DONE)**
```
  Scenario: Create and delete a timesheet
    Given I am a Manager
    When I navigate to "<test tenant>/TimesheetApp/modules/timesheetAdmin"
    And I create a new 'Timesheet from defaults' selecting myself as the employee
    Then I should see the created timesheet on the page
    When I delete the timesheet through the kebab menu
    Then the timesheet should be removed from the view
```
### Installation and Usage
Users will need to install [Katalon Studio](https://katalon.com/download) (and register for a free user) to run the tests.

### Test demos
I ran the test using webdrivers and headlessly as well.
Please see the video below:
- https://drive.google.com/file/d/1JUfI4Augopg5cJJH57pArEqmAg3I2nuE/view?usp=sharing

