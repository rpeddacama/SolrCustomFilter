# Custom Solr Filter for Word Concatenation

## Use case:
A name "De Vera Michael" which is an European origin should be returned in search results when someone search for "devera".

The customization needed to support above requirement is to be able to intercept during the index time for a given field at the character stream level and modify the character stream adding the merged tokens we are looking for before the next stage in the pipeline is called. Because the change we are making is at the core level, we need this executed before tokens are generated from the character stream by the search engine.
