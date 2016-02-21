Feature: Manage Movie

  
  Scenario: Verify showtime dates
    Given The User enters into the application
    When Enters into "Selección de Película" section
    And Select the number 1 choice of the results
    Then The Actual and future functions must be displayed.  
    
  
  Scenario: Search Movies
    Given The User enters into the application
    When Enters into "Selección de Película" section
    And Search movie "V"
    Then 3 movies must be displayed
    When Search movie "Vi"
    Then 2 movies must be displayed
    When Search movie "Vid"
    Then 1 movies must be displayed
    
  
  Scenario: Schedule Movie
    Given The User enters into the application
    When Enters into "Selección de Película" section
    And Search movie "Violinista del Diablo"
    And Select the number 1 choice of the results
    And Select showtime "2017-03-02 18:00"
    And Select numbers of seats "1" 
    And Select the seats in room 
   	  | Row                           | Column        |
      | 6                             | 11            |
    Then The success message should be displayed "La silla Fila:6-Columna:11 h sido asignada correctamente!"