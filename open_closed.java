/*
Consider an insurance system that validates health insurance claims before
approving one. We can follow the complementary Single Responsibility Principle
to model this requirement by creating two separate classes.
A HealthInsuranceSurveyor class responsible to validate claims and a
ClaimApprovalManager class responsible to approve claims.*/

public class HealthInsuranceSurveyor {
  public boolean isValidClaim() {
    System.out.println("HealthInsuranceSurveyor: Validating health insurance claim...");
    /*Logic to validate health insurance claims*/
    return true;
  }
}

public class ClaimApprovalManager {
  public void processHealthClaim (HealthInsuranceSurveyor surveyor)
  {
    if(surveyor.isValidClaim()){
      System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
    }
  }
}

/* Both the HealthInsuranceSurveyor and ClaimApprovalManager classes work fine
and the design for the insurance system appears perfect until a new requirement
to process vehicle insurance claims arises. We now need to include a new
VehicleInsuranceSurveyor class, and this should not create any problems.
, what we also need is to modify the ClaimApprovalManager class to process
vehicle insurance claims. This is how the modified ClaimApprovalManager will be:
*/

// ModifiedClaimApprovalManager.java
public class ClaimApprovalManager {
  public void processHealthClaim (HealthInsuranceSurveyor surveyor)
  {
    if(surveyor.isValidClaim()) {
      System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
    }
  }

  public void processVehicleClaim(VehicleInsuranceSurveyor surveyor)
  {
    if(surveyor.isValidClaim()){
      System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
    }
  }
}

/* In the example above, we modified the ClaimApprovalManager class by adding a
new processVehicleClaim() method to incorporate a new functionality
(claim approval of vehicle insurance).
o conform to the OC principle, let’s introduce a layer of abstraction by
creating an abstract class to represent different claim validation behaviors.*/

public abstract class InsuranceSurveyor {
  public abstract boolean isValidClaim();
}

// and then write the specific classes for each type of claim validation.

public class HealthInsuranceSurveyor extends InsuranceSurveyor{
  public boolean isValidClaim() {
    System.out.println("HealthInsuranceSurveyor: Validating health insurance claim...");
    /*Logic to validate health insurance claims*/
    return true;
  }
}

public class VehicleInsuranceSurveyor extends InsuranceSurveyor{
  public boolean isValidClaim() {
   System.out.println("VehicleInsuranceSurveyor: Validating vehicle insurance claim...");
    /*Logic to validate vehicle insurance claims*/
    return true;
  }
}

public class ClaimApprovalManager {
  public void processClaim(InsuranceSurveyor surveyor) {
    if(surveyor.isValidClaim()) {
      System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
    }
  }
}
 /* In the example above, we wrote a processClaim() method to accept a
 InsuranceSurveyor type instead of specifying a concrete type.
 In this way, any further addition of InsuranceSurveyor implementations
 will not affect the ClaimApprovalManager class.*/
