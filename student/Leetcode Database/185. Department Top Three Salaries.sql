# Write your MySQL query statement below

SELECT D.Name AS Department, E.Name AS Employee, E.Salary AS Salary
From Employee AS E, Department AS D
WHERE (SELECT COUNT(DISTINCT(Salary))
       From Employee
       WHERE DepartmentId = E.DepartmentId AND Salary > E.Salary) < 3
    AND E.DepartmentId = D.Id
ORDER BY E.DepartmentId, E.Salary DESC;
