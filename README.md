# covid19


sequenceDiagram
	actor User 
	participant GUI 
	participant Contract
	User->>+GUI:Submits test request
	GUI->>+Contract: CreateTestRequest(id, toStartAt, testSpecification)
	Contract-->>-GUI: response indicating whether operation was successful
	GUI-->>-User: Informs if action was successfull
