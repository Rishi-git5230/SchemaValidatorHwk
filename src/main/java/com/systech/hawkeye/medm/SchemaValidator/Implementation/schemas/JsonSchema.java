package com.systech.hawkeye.medm.SchemaValidator.Implementation.schemas;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class JsonSchema {

    // Make the validate method static
    public static void validate(JSONObject jsonObject) {
        JSONObject schemaJson = new JSONObject("{\n" +
                "    \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
                "        \"PrimaryProductID\": {\n" +
                "            \"type\": \"object\",\n" +
                "            \"properties\": {\n" +
                "                \"PrimaryIdentification\": {\n" +
                "                    \"type\": \"object\",\n" +
                "                    \"properties\": {\n" +
                "                        \"ProductID\": { \"type\": \"string\" },\n" +
                "                        \"ProductIDType\": { \"type\": \"string\" }\n" +
                "                    },\n" +
                "                    \"required\": [\"ProductID\", \"ProductIDType\"]\n" +
                "                }\n" +
                "            },\n" +
                "            \"required\": [\"PrimaryIdentification\"]\n" +
                "        },\n" +
                "        \"ProductName\": { \"type\": \"string\" },\n" +
                "        \"ProductDescription\": { \"type\": \"string\" },\n" +
                "        \"MinimumTemperature\": { \"type\": \"string\" },\n" +
                "        \"MaximumTemperature\": { \"type\": \"string\" },\n" +
                "        \"TemperatureUoM\": { \"type\": \"string\" },\n" +
                "        \"SensitiveToLight\": { \"type\": \"boolean\" },\n" +
                "        \"ShelfLife\": { \"type\": \"integer\" },\n" +
                "        \"ShelfLifeUoM\": { \"type\": \"string\" },\n" +
                "        \"AdditionalProductIDs\": {\n" +
                "            \"type\": \"array\",\n" +
                "            \"items\": {\n" +
                "                \"type\": \"object\",\n" +
                "                \"properties\": { \"name\": { \"type\": \"string\" } },\n" +
                "                \"required\": [\"name\"]\n" +
                "            }\n" +
                "        },\n" +
                "        \"PharmaInfo\": {\n" +
                "            \"type\": \"object\",\n" +
                "            \"properties\": {\n" +
                "                \"PrimaryProductID\": { \"type\": \"string\" },\n" +
                "                \"Dosage\": { \"type\": \"string\" },\n" +
                "                \"Strength\": { \"type\": \"string\" },\n" +
                "                \"PackageSize\": { \"type\": \"string\" },\n" +
                "                \"Classification\": { \"type\": \"string\" },\n" +
                "                \"GenericName\": { \"type\": \"string\" },\n" +
                "                \"ControlledSubstance\": { \"type\": \"string\" },\n" +
                "                \"MAHID\": { \"type\": \"string\" },\n" +
                "                \"MAHIDType\": { \"type\": \"string\" },\n" +
                "                \"ActiveIngredient\": { \"type\": \"string\" },\n" +
                "                \"ManufacturedBy\": { \"type\": \"string\" }\n" +
                "            },\n" +
                "            \"required\": [\"PrimaryProductID\", \"Dosage\", \"Strength\", \"PackageSize\", \"Classification\", \"GenericName\", \"ControlledSubstance\", \"MAHID\", \"MAHIDType\", \"ActiveIngredient\", \"ManufacturedBy\"]\n" +
                "        },\n" +
                "        \"TargetMarket\": {\n" +
                "            \"type\": \"array\",\n" +
                "            \"items\": {\n" +
                "                \"type\": \"object\",\n" +
                "                \"properties\": {\n" +
                "                    \"TargetMarketCountryCode\": { \"type\": \"string\" },\n" +
                "                    \"TMLanguage\": { \"type\": \"string\" },\n" +
                "                    \"LabelImage\": { \"type\": \"string\" },\n" +
                "                    \"Type\": { \"type\": \"string\" },\n" +
                "                    \"ManufacturerID\": { \"type\": \"string\" },\n" +
                "                    \"ManufacturerIDType\": { \"type\": \"string\" }\n" +
                "                },\n" +
                "                \"required\": [\"TargetMarketCountryCode\", \"TMLanguage\", \"LabelImage\", \"Type\", \"ManufacturerID\", \"ManufacturerIDType\"]\n" +
                "            }\n" +
                "        },\n" +
                "        \"PackagingInfo\": {\n" +
                "            \"type\": \"array\",\n" +
                "            \"items\": {\n" +
                "                \"type\": \"object\",\n" +
                "                \"properties\": {\n" +
                "                    \"PackagingCode\": { \"type\": \"string\" },\n" +
                "                    \"PackagingCodeType\": { \"type\": \"string\" },\n" +
                "                    \"UoM\": { \"type\": \"string\" },\n" +
                "                    \"ChildItemCount\": { \"type\": \"string\" },\n" +
                "                    \"PackagingRatio\": { \"type\": \"string\" }\n" +
                "                },\n" +
                "                \"required\": [\"PackagingCode\", \"PackagingCodeType\", \"UoM\", \"ChildItemCount\", \"PackagingRatio\"]\n" +
                "            }\n" +
                "        },\n" +
                "        \"Status\": { \"type\": \"string\" }\n" +
                "    },\n" +
                "    \"required\": [\"PrimaryProductID\", \"ProductName\", \"ProductDescription\", \"MinimumTemperature\", \"MaximumTemperature\", \"TemperatureUoM\", \"SensitiveToLight\", \"ShelfLife\", \"ShelfLifeUoM\", \"AdditionalProductIDs\", \"PharmaInfo\", \"TargetMarket\", \"PackagingInfo\", \"Status\"]\n" +
                "}");

        Schema schema = SchemaLoader.load(schemaJson);
        schema.validate(jsonObject);
    }
}
