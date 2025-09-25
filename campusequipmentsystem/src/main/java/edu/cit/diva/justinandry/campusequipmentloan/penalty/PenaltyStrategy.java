package edu.cit.diva.justinandry.campusequipmentloan.penalty;

import edu.cit.diva.justinandry.campusequipmentloan.model.LoanModel;

public interface PenaltyStrategy {
    double calculatePenalty(LoanModel loan);
}
