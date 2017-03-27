package com.sg.lambda.chapter5;

public class StringCombiner {

    private String separator;
    private String prefix;
    private String suffix;

    private StringBuilder builder = new StringBuilder();

    public StringCombiner(String separator, String prefix, String suffix) {
        this.separator = separator;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public StringCombiner add(String element) {
        if (areAtStart()) {
            builder.append(prefix);
        } else {
            builder.append(separator);
        }
        builder.append(element);

        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        this.builder.append(other.builder);
        return this;
    }

    private boolean areAtStart() {
        return builder.length() <= 1;
    }

    @Override
    public String toString() {
        return builder.toString() + suffix;
    }
}
