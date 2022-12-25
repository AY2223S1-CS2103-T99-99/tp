package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class TotalCommand extends Command{
    public static final String COMMAND_WORD = "total";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " 12/12/2022";

    public static final String MESSAGE_SUCCESS = "Total cars on date xxx displayed";

    private final LocalDate date;
    private int count;

    public TotalCommand(String dateIns) {
        requireNonNull(dateIns);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatter = formatter.withLocale(Locale.ENGLISH);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate dateOne = LocalDate.parse(dateIns, formatter);
//        checkArgument(isValidArrival(arrival), MESSAGE_CONSTRAINTS);
        this.date = dateOne;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        for (Person person : lastShownList) {
            if (person.isWithinRange(date))
                count++;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedString = date.format(formatter);
        return new CommandResult(
                String.format(Messages.MESSAGE_DATE_CARS_OVERVIEW , count, formattedString));
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedString = date.format(formatter);
        return formattedString;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TotalCommand // instanceof handles nulls
                && date.equals(((TotalCommand) other).date)); // state check
    }
}
