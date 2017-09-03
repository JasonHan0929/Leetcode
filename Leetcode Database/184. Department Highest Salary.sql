# Write your MySQL query statement below

SELECT D.Name AS
Department, E.Name AS Employee, E.Salary AS Salary
FROM Employee AS E, Department AS D
WHERE E.Salary = (SELECT MAX(Salary) FROM Employee WHERE DepartmentId = D.Id)
    AND E.DepartmentId = D.Id
