# SafeSpace
PFE SafeSpace Project
In Database : Table user : typ :
Type 0 = patient
Type 1 = pro
Type 2 = normal user


Database physical schema :
user(**id**,nom,prenom,mail,mdp,typ,_#pro_id_)
comm(**id**,_#user_id_)
acti(**id**,_#user_id_,etat,content)
stat(**id**,_#user_id_,typ,valeur)
exercice(**id**,_#patient_id_,nom,_#pro_id_)
rdv(**id**,_#pro_id_,_#patient_id_,daterdv)

