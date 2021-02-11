Feature: Links on TRMS Options page work

	Background:
		Given User is on Options page
		
	Scenario:
		When User clicks Create New Request
		Then The title of the page should be Tuition Reimbursement Form
		
	Scenario:
		When User clicks View My Requests
		Then The title of the page should be Request Viewer
		
	Scenario:
		When User clicks Open Message Center
		Then The title of the page should be Message Center