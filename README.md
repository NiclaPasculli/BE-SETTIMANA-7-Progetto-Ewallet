# BE-SETTIMANA-7-Progetto-Ewallet
Progetto Ewallet
ESEMPI
CREA CONTO:
POST---http://localhost:8080/EWallet/rest/contocorrente/creaconto

{
"dataCreazione": "21/11/2015",
"iban": 456905643,
"saldo": 6890.0,
"intestatario": "Moro Fabrizio"
}

EFFETTUA MOVIMENTO(PRELEVA):
PUT----http://localhost:8080/EWallet/rest/contocorrente/preleva/10.0/12-05-2021
{
"dataCreazione": "21/11/2015",
"iban": 456905643,
"saldo": 6890.0,
"intestatario": "Moro Fabrizio"
}
