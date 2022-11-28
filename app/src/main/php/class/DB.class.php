<?php

	class DB
	{
		// Variable preparation.
		var $db_host = "localhost";
										
		var $db_user = "u1802728_techi";
		var $db_password = "techi.pedulilansia";
		var $db_name = "u1802728_techi_pedulilansia";
		var $db_link;
		var $result = 0;

		// Default constructor.
		function DB()
		{

		}

		// Open database connection.
		function open()
		{
			$this->db_link = mysqli_connect($this->db_host, $this->db_user, $this->db_password, $this->db_name);
			if (!$this->db_link)
			{
				die('Could not connect: ' . mysqli_error($this->db_link));
			}			
		}

		// Execute query to MySQL.
		function execute($query = "")
		{
			$this->result = mysqli_query($this->db_link, $query);
			return $this->result;
		}

		// Get result from executed query.
		function get_result()
		{
			return mysqli_fetch_array($this->result);
		}

		// Get total row from executed query.
		function get_row()
		{
			return mysqli_num_rows($this->result);
		}

		// Close database connection.
		function close()
		{
			mysqli_close($this->db_link);
		}
	}
?>