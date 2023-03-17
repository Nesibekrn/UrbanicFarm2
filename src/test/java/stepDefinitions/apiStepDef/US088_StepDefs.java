package stepDefinitions.apiStepDef;

import io.cucumber.java.en.And;
import utilities.ApiUtilities;

import java.util.List;
import java.util.Random;

import static stepDefinitions.apiStepDef.US082_StepDefs.token;

public class US088_StepDefs {


    Integer id;
    Random random = new Random();

    public static List<Integer> addressIds;

    @And("the user updates the address")
    public void theUserUpdatesTheAddress() {
//        addressIds= ApiUtilities.Address.getAddress(USER.valueOf(token));
        addressIds= ApiUtilities.Address.getAddress(token);
        id=addressIds.get(random.nextInt(addressIds.size()));
        ApiUtilities.Address.updateAddress(id, "Toronto",
                "Mississauga", true, false,
                "13579", "On", "Office", false, token);
    }
}
