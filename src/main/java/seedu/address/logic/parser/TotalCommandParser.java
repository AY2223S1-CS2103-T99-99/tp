package seedu.address.logic.parser;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.TotalCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class TotalCommandParser implements Parser<TotalCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the TotalCommand
     * and returns a TotalCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public TotalCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, TotalCommand.MESSAGE_USAGE));
        }

        //check if it is a valid date

        return new TotalCommand(trimmedArgs);
    }
}