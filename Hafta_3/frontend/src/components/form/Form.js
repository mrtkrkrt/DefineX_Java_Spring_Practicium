import React, { useState, useEffect } from "react";
import { Country, State, City } from "country-state-city";
import Select from "react-select";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import { Hidden } from "@mui/material";

function Form() {
  const [selectedCountry, setSelectedCountry] = useState(null);
  const [selectedState, setSelectedState] = useState(null);
  const [days, setDays] = useState(null);
  const [error, setError] = useState(null);
  const [result, setResult] = useState(null);

  const postRequest = (state) => {
    if (selectedCountry === null || selectedState === null || days === null) {
      setError("Please fill all the fields");
      return;
    }

    setError(null);

    fetch("http://localhost:8080/v1/weather", {
      method: "POST",
      body: JSON.stringify({
        "country": selectedCountry.name,
        "city": selectedState.name,
        "days": days
      }),
    })
      .then((response) => {
        if (response.status === 200) {
          return response.json();
        } else {
          setError("Error");
        }
      })
      .then((data) => {
        console.log(data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div
      style={{
        display: "flex",
        width: "100%",
        marginTop: "10%",
        marginLeft: "30%",
        gap: "40px",
      }}
    >
      <div
        style={{
          width: "30%",
        }}
      >
        <h3
          style={{
            textAlign: "center",
          }}
        >
          WEATHER CONDITION
        </h3>
        <span style={{ fontWeight: "bold" }}>Country</span>
        <Select
          options={Country.getAllCountries()}
          getOptionLabel={(options) => {
            return options["name"];
          }}
          getOptionValue={(options) => {
            return options["name"];
          }}
          value={selectedCountry}
          onChange={(item) => {
            setSelectedCountry(item);
          }}
        />
        <br></br>
        <span style={{ fontWeight: "bold" }}>City</span>
        <Select
          options={State?.getStatesOfCountry(selectedCountry?.isoCode)}
          getOptionLabel={(options) => {
            return options["name"];
          }}
          getOptionValue={(options) => {
            return options["name"];
          }}
          value={selectedState}
          onChange={(item) => {
            setSelectedState(item);
          }}
        />
        <br></br>
        <div
          style={{
            display: "flex",
            gap: "20px",
          }}
        >
          <TextField
            id="outlined-number"
            label="Days"
            type="number"
            InputProps={{ inputProps: { min: 0, max: 14 } }}
            InputLabelProps={{
              shrink: true,
            }}
            onChange={(item) => {
              setDays(item.target.value);
            }}
          />
        </div>
        <br></br>
        <br></br>
        <Button variant="contained" onClick={postRequest}>
          Get Weather
        </Button>
        <br></br>
        <br></br>
        <label
          style={{
            color: "red",
            fontWeight: "bold",
          }}
        >
          {error}
        </label>
      </div>
      <div
        style={{
          width: "60%",
        }}
      >
        <label>RESULT</label>
      </div>
    </div>
  );
}

export default Form;
