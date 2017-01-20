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
        String APP_NAME = "BTreeTraverser";

    }

    interface LogMessages {

        String ERROR_INVALID_INPUT = "Invalid value [%s] provided for tree node";
        String ERROR_INCORRECT_TRAVERSAL_OPTION = "Incorrect traversal option selected";
        String ERROR_INPUT_VALUE_INVALID = "Input not one of the possible values.";

        String INFO_NEXT_STEP_TRAVERSAL_TYPE = "Moving to next step to show the output of traversal.";
        String INFO_NEXT_STEP_TRAVERSE_TREE = "Moving to next step to build and traverse tree.";
        String INFO_NEXT_STEP_CAPTURE_TRAVERSAL_TYPE = "Moving to next step to capture traversal type.";
        String INFO_LAST_STEP_EXECUTED = "Last step executed. No next step remaining.";

        String INFO_INORDER_SCANNING = "InOrder: Scanning value [%s]";
        String INFO_POST_ORDER_SCANNING = "PostOrder: Scanning value [%s]";
        String INFO_PRE_ORDER_SCANNING = "PreOrder: Scanning value [%s]";

        String INFO_INSERTING_INTO_TREE = "Inserting value [%s] into tree";
        String INFO_BUILDING_TREE = "Building tree from inputs";
        String INFO_TRAVERSING_TREE = "Traversing tree with selected strategy.";

    }
}
