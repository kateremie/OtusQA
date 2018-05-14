Feature: hh
Scenario Outline: Finding job
Given I am on the hh.ru main page
When I search for <query>
Then The page title contains <searchresults>

  Examples:
  |query|searchresults|
  |QA   |QA           |
  |QA automation| QA automation|
  |QA lead      | QA lead      |