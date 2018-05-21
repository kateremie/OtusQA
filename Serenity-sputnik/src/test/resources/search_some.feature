Feature: Working with Search on https://www.sputnik.ru
Scenario Outline: Search some
Given User on the Sputnik search page
When User search for <query>
Then Search results contains <results>

  Examples:
  |query|results|
  |HTCPCP|HTCPCP|