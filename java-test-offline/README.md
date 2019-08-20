# Java Test
### Background
This application generates a report for the catalog-to-categories mapping service.  
It iterates over a fixed number of catalogs for specific site IDs and prints out which categories are mapped for each catalog.  

**Service Call Example:**<br>
http://localhost:8080/catalogmapping/getcatalogmapping/json/{catalogId}/{siteId}<br>
http://localhost:8080/catalogmapping/getcatalogmapping/json/1/0

**Report Example**<br>
*Site 0 - Catalog 4 is mapped to category "England" (121491)*


### Current issues
- Bad design / architecture
- Code is poorly written
- Bad performance
- No error handling 
- No tests


### Requirement
- Refactor the application so all the current issues are resolved
- In the report, for each catalog, the results should be sort category ID (ascending) p
- Service requests with status "FAILURE" are not properly handled (i.e site 0, catalog 11). Please print failed resources input.
(i.e print a line at the end of the report: "failed request parameters: \[(0,11), (<site>,<category>)])" 
- Tests. At least for the spots that need to be tested (up to you to decide where). 



### Highlights
- The application should be well designed and written
- The application should run as efficiently as possible, in terms of execution time
- The report should be sorted by category ID, ascending
- Any framework or external library can be used


Good luck!
