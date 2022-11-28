<?php

class Relative extends DB
{
    // Add data with default value.
    function add_data($email, $name, $password)
    {
        $query = "INSERT INTO relatives VALUES ('$email', '$name', '$password')";
        return $this->execute($query);
    }
    
    // Delete data.
    function delete_data($id)
    {
        $query = "DELETE FROM relatives WHERE email = '$id'";
        return $this->execute($query);
    }

    // Get default data.
    function get_data()
    {
        $query = "SELECT * FROM relatives";
        return $this->execute($query);
    }

    function get_user($id)
    {
        $query = "SELECT * FROM relatives WHERE email = '$id'";
        return $this->execute($query);
    }
}

?>