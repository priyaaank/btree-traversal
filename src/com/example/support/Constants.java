package com.example.support;

public interface Constants {

    interface IOConstants {

        String POSSIBLE_OPTIONS = "Possible options are %s :";
        String COMMA_SEPARATED_VALUE_PROMPT = "Enter value input separated by comma : ";
        String TRAVERSAL_OPTIONS = "Select traversal type: Inorder, PostOrder, PreOrder: ";
        String TRAVERSAL_OPTION_INCORRECT = "That is not a valid traversal option. Try again. \n";
        String FINAL_OUTPUT_PROMPT = "The output for selected traversal is:";
        String SKIP_ERROR_PROMPT = "Input contains an invalid value [%s]. It doesn't look like an integer. try again. \n";
        String IN = "IN";
        String PO = "PO";
        String PR = "PR";

    }

    interface Defaults {

        String EMPTY_STRING = "";

    }
}
