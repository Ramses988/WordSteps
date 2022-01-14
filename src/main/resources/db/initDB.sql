DROP TABLE IF EXISTS words;
DROP TABLE IF EXISTS dictionaries_words;

CREATE TABLE dictionaries_words
(
    id           INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name         VARCHAR           NOT NULL,
    images       VARCHAR           NOT NULL
);

CREATE TABLE words
(
    id                  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    word                VARCHAR           NOT NULL,
    transcription       VARCHAR           NOT NULL,
    translate           VARCHAR           NOT NULL,
    status              INTEGER           NOT NULL,
    next_date           TIMESTAMP         NULL,
    dictionary_id       INTEGER           NOT NULL,
    FOREIGN KEY (dictionary_id) REFERENCES dictionaries_words (id)
);
CREATE UNIQUE INDEX words_unique_word_idx ON words (word);