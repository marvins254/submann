<?php
$host = "localhost";   //Host
$username = "root";    //User
$password = ""; //Passsword
$database = "advanced_yii2";     // Database Name
 
//creating a new connection object using mysqli 
$conn = new mysqli($id, $username, $password, $database);
 
//if there is some error connecting to the database
//with die we will stop the further execution by displaying a message causing the error.
if ($conn->connect_error) {
    die("Database connection failed: " . $conn->connect_error);
}
?>