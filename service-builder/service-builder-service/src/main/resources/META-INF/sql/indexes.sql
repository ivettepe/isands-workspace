create index IX_319304EA on isands_ElectroEmployee (ElectroTypeId);
create index IX_1E3A5021 on isands_ElectroEmployee (companyId);
create index IX_EE076BC4 on isands_ElectroEmployee (employeeId);

create index IX_14853A32 on isands_ElectroType (name[$COLUMN_LENGTH:100$]);

create index IX_B3B4746D on isands_Electronics (ElectroTypeId);
create unique index IX_42482D43 on isands_Electronics (name[$COLUMN_LENGTH:150$]);

create unique index IX_56ADD1C3 on isands_Employee (firstName[$COLUMN_LENGTH:100$], lastName[$COLUMN_LENGTH:100$], patronymic[$COLUMN_LENGTH:100$]);
create index IX_C754565 on isands_Employee (positionId);

create index IX_8226DD21 on isands_PositionType (name[$COLUMN_LENGTH:100$]);

create index IX_D5237C42 on isands_Purchase (electronicsId);
create index IX_20FA605 on isands_Purchase (employeeId, electronicsId);

create index IX_6EC244F9 on isands_PurchaseType (name[$COLUMN_LENGTH:100$]);