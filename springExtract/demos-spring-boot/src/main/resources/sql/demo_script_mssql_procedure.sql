USE Demo_ENI;  
GO 
DROP PROCEDURE NbCoursDispenses;
GO  
--PROCEDURE STOCKEE : NbCoursDispenses
CREATE PROCEDURE NbCoursDispenses
	@email NVARCHAR(200),
	@nbCours int OUTPUT
AS  
    SET NOCOUNT ON;

    SELECT @nbCours = count(*)
    FROM COURS_FORMATEUR  
     WHERE email_formateur = @email;
    RETURN;
GO